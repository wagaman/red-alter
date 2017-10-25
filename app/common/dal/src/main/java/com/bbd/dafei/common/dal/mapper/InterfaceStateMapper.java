package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.dal.po.InterfaceStatePO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface InterfaceStateMapper {

    @Select("select *  from comp_api where id = #{id}")
    String findById(InterfaceStatePO statePO, @Param("appGuid") String appGuid);

    @Select("SELECT api_description  FROM comp_api")
    List<InterfaceStatePO> findAllInterface();
}
