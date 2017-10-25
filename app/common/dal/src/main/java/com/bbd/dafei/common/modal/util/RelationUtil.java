package com.bbd.dafei.common.modal.util;

import com.bbd.dafei.common.modal.dto.GatherPlaceDTO;
import com.bbd.dafei.common.modal.dto.RelationInfoDTO;
import com.bbd.dafei.common.modal.vo.RelationInfoVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wish on 2017/4/23.
 */
public class RelationUtil {
    /**
     * 将关联信息dto转换为前端需要的VO
     *
     * @param relationInfoDTO
     * @return
     */
    public static RelationInfoVO transRelationInfoDTOToRelationInfoVO(RelationInfoDTO relationInfoDTO) {
        RelationInfoVO relationInfoVO = new RelationInfoVO();
        if (relationInfoDTO == null) {
            return relationInfoVO;
        }

        //一度关联关键自然人
        relationInfoVO.setPivotalNaturalPersonsTop1d(getListFromString(relationInfoDTO.getPivotalNaturalPersonsTop1d()));
        //二度关联关键自然人
        relationInfoVO.setPivotalNaturalPersonsTop2d(getListFromString(relationInfoDTO.getPivotalNaturalPersonsTop2d()));
        //三度关联关键自然人
        relationInfoVO.setPivotalNaturalPersonsTop3d(getListFromString(relationInfoDTO.getPivotalNaturalPersonsTop3d()));
        //一度关联关键非自然人
        relationInfoVO.setPivotalNonNaturalPersonsTop1d(getListFromString(relationInfoDTO.getPivotalNonNaturalPersonsTop1d()));
        //二度关联关键非自然人
        relationInfoVO.setPivotalNonNaturalPersonsTop2d(getListFromString(relationInfoDTO.getPivotalNonNaturalPersonsTop2d()));
        //三度关联关键非自然人
        relationInfoVO.setPivotalNonNaturalPersonsTop3d(getListFromString(relationInfoDTO.getPivotalNonNaturalPersonsTop3d()));
        //一度关联聚集行业
        relationInfoVO.setIndustrySpanTop1d(getIndusrySpanTop(relationInfoDTO.getIndustrySpanRatio1d()));
        //二度关联聚集行业
        relationInfoVO.setIndustrySpanTop2d(getIndusrySpanTop(relationInfoDTO.getIndustrySpanRatio2d()));
        //三度关联聚集行业
        relationInfoVO.setIndustrySpanTop3d(getIndusrySpanTop(relationInfoDTO.getIndustrySpanRatio3d()));

        return relationInfoVO;
    }

    /**
     * 将字符串根据逗号拆分为List
     *
     * @param str
     * @return
     */
    private static List<String> getListFromString(String str) {
        if (StringUtils.isBlank(str)) {
            return new ArrayList<>();
        }
        return Arrays.asList(StringUtils.split(str, ","));
    }

    /**
     * 获取前三的关联聚集行业
     *
     * @param list
     * @return
     */
    private static List<String> getIndusrySpanTop(List<List<String>> list) {
        List<String> industrySpanTop = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
            return industrySpanTop;
        }
        for (List<String> strings : list) {
            if (CollectionUtils.isNotEmpty(strings) && strings.size() == 3) {
                industrySpanTop.add(strings.get(1));
            }
            //获取前三
            if (industrySpanTop.size() == 3) {
                return industrySpanTop;
            }
        }
        return industrySpanTop;
    }

}
