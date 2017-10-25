package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.service.components.ApiExceptionUtils;
import com.bbd.dafei.biz.service.components.ApiUtils;
import com.bbd.dafei.biz.shared.RelationRightInfoService;
import com.bbd.dafei.common.dal.mapper.RelationInfoMapper;
import com.bbd.dafei.common.modal.dto.RelationRightInfoDTO;
import com.bbd.dafei.common.modal.vo.*;
import com.bbd.dafei.common.util.ApiReturnBean;
import com.bbd.dafei.common.util.CommonUtil;
import com.google.common.reflect.TypeToken;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shi.jun on 2017/9/20.
 */
@Service
public class RelationRightInfoServiceImpl implements RelationRightInfoService {

    @Autowired
    private RelationInfoMapper relationInfoMapper;

    @Autowired
    private ApiUtils api;

    //搜索url
    @Value("${api.kpiInfo}")
    private String kpiUrl;

    @Override
    public RelationTotalInfoVO getRightRelation(String companyId) throws Exception {
        RelationTotalInfoVO relationTotalInfoVO = new RelationTotalInfoVO();
        RelationTotalInfoDetail1dVO relationTotalInfoDetail1dVO = new RelationTotalInfoDetail1dVO();
        RelationTotalInfoDetail2dVO relationTotalInfoDetail2dVO = new RelationTotalInfoDetail2dVO();
        RelationTotalInfoDetail3dVO relationTotalInfoDetail3dVO = new RelationTotalInfoDetail3dVO();
        RelationRightVO relationRightVO1d = relationInfoMapper.findRelationRightVO(companyId, 1);
        RelationRightVO relationRightVO2d = relationInfoMapper.findRelationRightVO(companyId, 2);
        RelationRightVO relationRightVO3d = relationInfoMapper.findRelationRightVO(companyId, 3);

        if(relationRightVO1d == null || relationRightVO2d==null || relationRightVO3d==null) {
            return null;
        }
        //数据平台获取kpi
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("unikey", companyId));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        RelationRightInfoDTO r = api.cacheThenGet(kpiUrl, new TypeToken<RelationRightInfoDTO>() {
        }, validDate, nvps);
        relationRightVO1d.setKeyNature(r.getKeyNature1d());
        relationRightVO2d.setKeyNature(r.getKeyNature2d());
        relationRightVO3d.setKeyNature(r.getKeyNature3d());
        relationRightVO1d.setKeyNoNature(r.getKeyNoNature1d());
        relationRightVO2d.setKeyNoNature(r.getKeyNoNature2d());
        relationRightVO3d.setKeyNoNature(r.getKeyNoNature3d());
        relationRightVO1d.setKey_industry(parseKeyIndustry(r.getKeyIndustry1d()));
        relationRightVO2d.setKey_industry(parseKeyIndustry(r.getKeyIndustry2d()));
        relationRightVO3d.setKey_industry(parseKeyIndustry(r.getKeyIndustry3d()));


        //unicode转换
        relationRightVO1d.setKeyLocation(unicode2String(relationRightVO1d.getKeyLocation()));
        relationRightVO2d.setKeyLocation(unicode2String(relationRightVO2d.getKeyLocation()));
        relationRightVO3d.setKeyLocation(unicode2String(relationRightVO3d.getKeyLocation()));


        //1度转换
        relationTotalInfoDetail1dVO.setKeyNature(relationRightVO1d.getKeyNature());
        relationTotalInfoDetail1dVO.setUnKeyNature(relationRightVO1d.getKeyNoNature());
        relationTotalInfoDetail1dVO.setBlackNum(relationRightVO1d.getBlacklistNum());
        relationTotalInfoDetail1dVO.setHighRiskNum(relationRightVO1d.getHighDangerCompanyNum());
        relationTotalInfoDetail1dVO.setNewFinanceNum(relationRightVO1d.getNewFinanceCompanyNum());
        relationTotalInfoDetail1dVO.setRelationIndustry(relationRightVO1d.getKey_industry());
        relationTotalInfoDetail1dVO.setRelationPlace(relationRightVO1d.getKeyLocation());
        relationTotalInfoDetail1dVO.setCommonInterestsNum(relationRightVO1d.getBenefitCons_num());
        relationTotalInfoDetail1dVO.setSameAddressNum(relationRightVO1d.getSameLocationCompanyNum());
        relationTotalInfoDetail1dVO.setCancelNum(relationRightVO1d.getRevokeCompanyNum());

        //2度转换
        relationTotalInfoDetail2dVO.setKeyNature(relationRightVO2d.getKeyNature());
        relationTotalInfoDetail2dVO.setUnKeyNature(relationRightVO2d.getKeyNoNature());
        relationTotalInfoDetail2dVO.setBlackNum(relationRightVO2d.getBlacklistNum());
        relationTotalInfoDetail2dVO.setHighRiskNum(relationRightVO2d.getHighDangerCompanyNum());
        relationTotalInfoDetail2dVO.setNewFinanceNum(relationRightVO2d.getNewFinanceCompanyNum());
        relationTotalInfoDetail2dVO.setRelationIndustry(relationRightVO2d.getKey_industry());
        relationTotalInfoDetail2dVO.setRelationPlace(relationRightVO2d.getKeyLocation());
        relationTotalInfoDetail2dVO.setCommonInterestsNum(relationRightVO2d.getBenefitCons_num());
        relationTotalInfoDetail2dVO.setSameAddressNum(relationRightVO2d.getSameLocationCompanyNum());
        relationTotalInfoDetail2dVO.setCancelNum(relationRightVO2d.getRevokeCompanyNum());

        //3度转换
        relationTotalInfoDetail3dVO.setKeyNature(relationRightVO3d.getKeyNature());
        relationTotalInfoDetail3dVO.setUnKeyNature(relationRightVO3d.getKeyNoNature());
        relationTotalInfoDetail3dVO.setBlackNum(relationRightVO3d.getBlacklistNum());
        relationTotalInfoDetail3dVO.setHighRiskNum(relationRightVO3d.getHighDangerCompanyNum());
        relationTotalInfoDetail3dVO.setNewFinanceNum(relationRightVO3d.getNewFinanceCompanyNum());
        relationTotalInfoDetail3dVO.setRelationIndustry(relationRightVO3d.getKey_industry());
        relationTotalInfoDetail3dVO.setRelationPlace(relationRightVO3d.getKeyLocation());
        relationTotalInfoDetail3dVO.setCommonInterestsNum(relationRightVO3d.getBenefitCons_num());
        relationTotalInfoDetail3dVO.setSameAddressNum(relationRightVO3d.getSameLocationCompanyNum());
        relationTotalInfoDetail3dVO.setCancelNum(relationRightVO3d.getRevokeCompanyNum());


        relationTotalInfoVO.setRelationTotalInfoDetail1dVO(relationTotalInfoDetail1dVO);
        relationTotalInfoVO.setRelationTotalInfoDetail2dVO(relationTotalInfoDetail2dVO);
        relationTotalInfoVO.setRelationTotalInfoDetail3dVO(relationTotalInfoDetail3dVO);
        return relationTotalInfoVO;
    }

    private String parseKeyIndustry(List<String[]> keyIndustry) {
        StringBuffer sb = new StringBuffer();
        if(keyIndustry == null) return sb.toString();
        for(String key[] : keyIndustry) {
            if(key.length == 3) {
                sb.append(key[1]);
                sb.append("、");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * Interger类型为NULL时设定为0
     *
     * @param value
     * @return
     */
    private int integerNullDataChange(Integer value) {
        if (null == value) {
            return 0;
        } else {
            return value;
        }
    }

    private String unicode2String(String unicode) {
        if (StringUtils.isBlank(unicode)) return null;
        unicode = unicode.replaceAll("u'", "");
        unicode = unicode.replaceAll("'", "");
        int pos = unicode.indexOf("\\");
        int i = -1;
        StringBuilder sb = new StringBuilder();
        while ((i = unicode.indexOf("\\u", pos)) != -1) {
            sb.append(unicode.substring(pos, i));
            if (i + 5 < unicode.length()) {
                pos = i + 6;
                sb.append((char) Integer.parseInt(unicode.substring(i + 2, i + 6), 16));
            }
        }
        return sb.toString();
    }

}
