package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.service.components.ApiExceptionUtils;
import com.bbd.dafei.biz.service.components.ApiUtils;
import com.bbd.dafei.biz.shared.RaBlackListService;
import com.bbd.dafei.biz.shared.RaCompanyService;
import com.bbd.dafei.biz.shared.RelationService;
import com.bbd.dafei.common.dal.mapper.RaGagherPlaceMapper;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.modal.commonenum.RelationNodeVOTypeEnum;
import com.bbd.dafei.common.modal.commonenum.RiskLevelEnum;
import com.bbd.dafei.common.modal.dto.*;
import com.bbd.dafei.common.modal.vo.RelationDataVO;
import com.bbd.dafei.common.modal.vo.RelationLinkVO;
import com.bbd.dafei.common.modal.vo.RelationNodeVO;
import com.bbd.dafei.common.util.ApiReturnBean;
import com.bbd.dafei.common.util.CommonUtil;
import com.bbd.wellspring.common.service.facade.relation.NodeVoSymbolEnum;
import com.bbd.wellspring.common.service.facade.relation.NodeVoTypeEnum;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wish on 2017/4/23.
 */
@Service
public class RelationServiceImpl implements RelationService {
    @Autowired
    private ApiUtils api;

    @Autowired
    private RaCompanyService raCompanyService;

    @Autowired
    private RaBlackListService raBlackListService;

    @Autowired
    private RaGagherPlaceMapper raGagherPlaceMapper;

    //DTO中的颜色对应前端所需的类型
    private final Map<String, RelationNodeVOTypeEnum> enumMap = new HashMap<String, RelationNodeVOTypeEnum>() {{
        put(NodeVoTypeEnum.TARGET.getRgb(), RelationNodeVOTypeEnum.TARGET);
        put(NodeVoTypeEnum.INVESTED.getRgb(), RelationNodeVOTypeEnum.INVESTED);
        put(NodeVoTypeEnum.DIRECTOR.getRgb(), RelationNodeVOTypeEnum.DJG);
        put(NodeVoTypeEnum.SUPERVISOR.getRgb(), RelationNodeVOTypeEnum.DJG);
        put(NodeVoTypeEnum.EXECUTIVE.getRgb(), RelationNodeVOTypeEnum.DJG);
        put(NodeVoTypeEnum.OTHER.getRgb(), RelationNodeVOTypeEnum.OTHER);
    }};

    //实时非财务v2接口url
    @Value("${api.ssfcwv2}")
    private String ssfcwv2Url;

    //查询关联方节点和关系url
    @Value("${api.transfer.relateNodeAndLink}")
    private String relateNodeAndLinkUrl;

    public RelationInfoDTO getRelationInfoByCompanyId(String companyId) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("key", "id"));
        nvps.add(new BasicNameValuePair("value", companyId));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<RelationInfoDTO> r = api.cacheThenGet(ssfcwv2Url, new TypeToken<ApiReturnBean<RelationInfoDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(ssfcwv2Url, r, nvps);
        }
        RelationInfoDTO relationInfoDTO = null;
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            relationInfoDTO = r.getResults().get(0);
        }
        return relationInfoDTO;
    }

    public RelationNowDTO.RelationData getRelationDataByQyxxIdAndDegree(String qyxxId, int degree) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("unikey", qyxxId));
        nvps.add(new BasicNameValuePair("degree", String.valueOf(degree)));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        RelationNowDTO relationNowDTO = api.cacheThenGet(relateNodeAndLinkUrl, new TypeToken<RelationNowDTO>() {
        }, validDate, nvps);
        if (!relationNowDTO.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(relateNodeAndLinkUrl, relationNowDTO, nvps);
        }
        return relationNowDTO.getData();
    }

    public RelationDataVO getRelationNodesAndLinks(String qyxxId, int degree) throws Exception {
        RelationNowDTO.RelationData relationData = getRelationDataByQyxxIdAndDegree(qyxxId, degree);

        RelationDataVO relationDataVO = new RelationDataVO();
        List<RelationNodeVO> relationNodeVOList = new ArrayList<RelationNodeVO>();
        List<RelationLinkVO> relationLinkVOList = new ArrayList<RelationLinkVO>();
        relationDataVO.setNodes(relationNodeVOList);
        relationDataVO.setLinks(relationLinkVOList);
        if (relationData == null) {
            return relationDataVO;
        }
        Map<String, RelationNodeVO> relationNodeVOMap = new HashMap<>();
        //获取查询到的所有公司id，用于去数据库匹配黑名单和高风险企业
        Set<String> companyIds = new HashSet<>();
        //处理节点
        if (CollectionUtils.isNotEmpty(relationData.getNodes())) {
            int numIndex = 1;
            for (RelationNodeDTO relationNodeDTO : relationData.getNodes()) {
                if (NodeVoSymbolEnum.rect.equals(relationNodeDTO.getSymbol())) {
                    companyIds.add(relationNodeDTO.getName());//id
                }
                //生成节点VO
                RelationNodeVO relationNodeVO = generateRelationNodeVO(relationNodeDTO, numIndex ++);
                relationNodeVOList.add(relationNodeVO);
                //加入到id和
                relationNodeVOMap.put(relationNodeVO.getName(), relationNodeVO);
            }
        }
        //批量查询本地库的公司信息，设置到对应VO
        List<String> highCompanyList = matchDataBaseCompanyInfo(relationNodeVOMap, companyIds);
        //批量查询本地黑名单，设置到对应VO
        List<String> blackCompanyList = handleBlackCompany(relationNodeVOMap, companyIds);
        //在黑名单中的企业，不计算为高危
        highCompanyList.removeAll(blackCompanyList);
        //去除目标公司，只统计关联方
        highCompanyList.remove(qyxxId);
        blackCompanyList.remove(qyxxId);
        relationDataVO.setHighCompanyList(highCompanyList);
        relationDataVO.setBlackCompanyList(blackCompanyList);

        //处理连线
        if (CollectionUtils.isNotEmpty(relationData.getLinks())) {
            for (RelationLinkDTO linkDTO : relationData.getLinks()) {
                RelationLinkVO relationLinkVO = new RelationLinkVO();
                BeanUtils.copyProperties(linkDTO, relationLinkVO);
                relationLinkVOList.add(relationLinkVO);
            }
        }

        return relationDataVO;
    }

    /**
     * 生成关联节点VO
     * @param relationNodeDTO
     * @param numIndex
     * @return
     */
    private RelationNodeVO generateRelationNodeVO(RelationNodeDTO relationNodeDTO, int numIndex) {
        RelationNodeVO relationNodeVO = new RelationNodeVO();
        BeanUtils.copyProperties(relationNodeDTO, relationNodeVO, "color");
        //股东和自然人股东的颜色是一致的，需要根据symbol区分
        if (NodeVoTypeEnum.INVEST.getRgb().equals(relationNodeDTO.getColor())) {
            if (NodeVoSymbolEnum.rect.getSymbol().equals(relationNodeDTO.getSymbol().getSymbol())) {
                //股东
                relationNodeVO.setColor(RelationNodeVOTypeEnum.INVEST.getCode());
                relationNodeVO.setRelationDescribe(RelationNodeVOTypeEnum.INVEST.getName());
            } else {
                //自然人股东
                relationNodeVO.setColor(RelationNodeVOTypeEnum.HUMAN_INVEST.getCode());
                relationNodeVO.setRelationDescribe(RelationNodeVOTypeEnum.HUMAN_INVEST.getName());
            }
        } else {
            RelationNodeVOTypeEnum relationNodeVOTypeEnum = enumMap.get(relationNodeDTO.getColor());
            if (relationNodeVOTypeEnum != null) {
                relationNodeVO.setColor(relationNodeVOTypeEnum.getCode());
                relationNodeVO.setRelationDescribe(relationNodeVOTypeEnum.getName());
            }
        }

        relationNodeVO.setNumIndex(numIndex);
        //如果是公司，设置是否被拉黑默认值false
        if (NodeVoSymbolEnum.rect.getSymbol().equals(relationNodeDTO.getSymbol().getSymbol())) {
            relationNodeVO.setBlack(false);
        }
        return relationNodeVO;
    }

    /**
     * 根据companyIds批量查询本地库公司信息，并设置到relationNodeVOMap中对应的VO
     * @param relationNodeVOMap 公司id对应RelationNodeVO映射
     * @param companyIds 公司id集合
     * @return 高风险公司id集合
     */
    private List<String> matchDataBaseCompanyInfo(Map<String, RelationNodeVO> relationNodeVOMap, Set<String> companyIds) {
        List<String> highCompanyList = new ArrayList<String>();
        //查询公司信息
        List<RaCompanyPO> companys = raCompanyService.findCompanysByIds(companyIds);
        //遍历公司信息，设置到VO
        if (CollectionUtils.isNotEmpty(companys)) {
            for (RaCompanyPO company : companys) {
                RelationNodeVO relationNodeVO = relationNodeVOMap.get(company.getId());
                if (relationNodeVO == null) {
                    continue;
                }
                relationNodeVO.setIndustry(company.getIndustry());
                relationNodeVO.setRiskLevel(company.getRiskLevel());
                relationNodeVO.setRiskIndex(company.getRiskIndex());
                //高危预警
                if (RiskLevelEnum.RISK_LEVEL_HIGH.getName().equals(company.getRiskLevel())) {
                    relationNodeVO.setColor(RelationNodeVOTypeEnum.HIGH_RISK.getCode());
                    highCompanyList.add(company.getId());
                }

            }
        }
        return highCompanyList;
    }

    /**
     * 根据companyIds批量查询黑名单，并设置到relationNodeVOMap中对应的VO
     * @param relationNodeVOMap 公司id对应RelationNodeVO映射
     * @param companyIds 公司id集合
     * @return 黑名单id集合
     */
    private List<String> handleBlackCompany(Map<String, RelationNodeVO> relationNodeVOMap, Set<String> companyIds) {
        //查询黑名单
        List<String> blackCompanyIds = raBlackListService.findBlackListByCompanyIds(companyIds);
        //遍历黑名单，设置到VO
        if (CollectionUtils.isNotEmpty(blackCompanyIds)) {
            for (String blackCompanyId : blackCompanyIds) {
                RelationNodeVO relationNodeVO = relationNodeVOMap.get(blackCompanyId);
                if (relationNodeVO != null) {
                    relationNodeVO.setColor(RelationNodeVOTypeEnum.BLACK.getCode());
                    relationNodeVO.setBlack(true);
                }
            }
        }
        return blackCompanyIds;
    }
}
