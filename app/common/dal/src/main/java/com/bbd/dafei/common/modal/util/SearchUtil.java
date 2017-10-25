package com.bbd.dafei.common.modal.util;

import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.modal.dto.SearchCompanyDTO;
import com.bbd.dafei.common.modal.vo.SearchCompanyVO;
import com.bbd.dafei.common.util.Constants;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 搜索企业信息工具类
 * Created by wish on 2017/4/25.
 */
public class SearchUtil {
    /**
     * 构建搜索VO
     *
     * @param searchCompanyDTOList 搜索结果
     * @param companyPOList        本地数据库公司信息
     * @param blackCompanyIds      黑名单中的公司id
     * @param userProvince         登录用户所在区域
     * @return
     * @throws Exception
     */
    public static List<SearchCompanyVO> transToSearchCompanyVO(List<SearchCompanyDTO> searchCompanyDTOList, List<RaCompanyPO> companyPOList,
                                                               List<String> blackCompanyIds, String userProvince) throws Exception {
        List<SearchCompanyVO> searchCompanyVOList = new ArrayList<>();
        if (blackCompanyIds == null) {
            blackCompanyIds = new ArrayList<>();
        }
        if (CollectionUtils.isEmpty(searchCompanyDTOList)) {
            return searchCompanyVOList;
        }
        Map<String, RaCompanyPO> map = new HashMap<String, RaCompanyPO>();
        if (CollectionUtils.isNotEmpty(companyPOList)) {
            for (RaCompanyPO raCompanyPO : companyPOList) {
                if (raCompanyPO == null) {
                    continue;
                }
                map.put(raCompanyPO.getId(), raCompanyPO);
            }
        }

        for (SearchCompanyDTO searchCompanyDTO : searchCompanyDTOList) {
            SearchCompanyVO searchCompanyVO = new SearchCompanyVO();
            BeanUtils.copyProperties(searchCompanyVO, searchCompanyDTO);
            String companyId = searchCompanyDTO.getBbdQyxxId();
            RaCompanyPO raCompanyPO = map.get(companyId);
            if (raCompanyPO != null) {
                searchCompanyVO.setRiskLevel(raCompanyPO.getRiskLevel());
                searchCompanyVO.setRiskIndex(raCompanyPO.getRiskIndex());
                searchCompanyVO.setRise(raCompanyPO.getRise());
                searchCompanyVO.setIndustry(raCompanyPO.getIndustry());
            }
            //没有新金融行业标签，则显示普通行业标签
            if(StringUtils.isEmpty(searchCompanyVO.getIndustry())) {
                searchCompanyVO.setIndustry(Constants.INDUSTRY_DESCRIBE_MAP.get(searchCompanyDTO.getCompanyIndustry()));
            }

            //是否有权限查看详情，同一区域才能查看
            searchCompanyVO.setHasPermission(CompanyPermissionUtil.hasPermission(userProvince, searchCompanyVO.getProvince()));
            searchCompanyVO.setBlack(blackCompanyIds.contains(companyId));

            searchCompanyVOList.add(searchCompanyVO);
        }

        return searchCompanyVOList;
    }

    /**
     * 从多个行业标签中找出优先级最高的标签
     *
     * @param tags
     * @return
     */
    public static String getMaxWeightTagFromTags(List<String> tags) {
        if (CollectionUtils.isEmpty(tags)) {
            return null;
        }
        String result = null;
        int maxWeight = -1;
        //遍历，找出权重最高的标签
        for (String tag : tags) {
            Integer weight = Constants.INDUSTRY_WEIGHT_MAP.get(tag);
            if (weight != null && weight > maxWeight) {
                result = tag;
                maxWeight = weight;
            }
        }
        return result;
    }


}
