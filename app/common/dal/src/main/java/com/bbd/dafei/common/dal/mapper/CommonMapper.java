package com.bbd.dafei.common.dal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * @author Ian.Su
 * @version $Id: CommonMapper.java, v 0.1 2017/4/21 18:26 Ian.Su Exp $
 */
public interface CommonMapper {

    /**
     * 查询所有省份
     *
     * @return
     */
    List<String> getProvinces();


    /**
     * 根据省份获取城市
     *
     * @return 返回城市列表
     */
    List<String> getCitys(@Param("province") String province);


    List<String> getAreas(@Param("province") String province, @Param("city") String city);

    List<Map<String, Object>> exesql(@Param("sql") String sql);
}
