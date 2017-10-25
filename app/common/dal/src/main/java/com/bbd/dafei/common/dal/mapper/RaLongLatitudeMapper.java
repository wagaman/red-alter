package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.dal.po.RaLongiLatitudePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ian.Su
 * @version $Id: RaLongLatitudeMapper.java, v 0.1 2017/4/25 16:20 Ian.Su Exp $
 */
public interface RaLongLatitudeMapper {

    List<RaLongiLatitudePO> query(@Param("province") String province,
                                  @Param("city")     String city,
                                  @Param("area")     String area);

}
