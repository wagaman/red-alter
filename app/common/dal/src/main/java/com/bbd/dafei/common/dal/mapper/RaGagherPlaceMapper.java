package com.bbd.dafei.common.dal.mapper;

/**
 * Created by wish on 2017/5/6.
 */
public interface RaGagherPlaceMapper {
    /**
     * 根据公司id查询关联聚集地
     * @param companyId
     * @return
     */
    String findGatherPlaceByCompanyId(String companyId);
}
