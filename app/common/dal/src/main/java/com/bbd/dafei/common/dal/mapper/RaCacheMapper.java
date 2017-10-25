package com.bbd.dafei.common.dal.mapper;

import java.util.Date;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Ian.Su
 * @version $Id: RaCacheMapper.java, v 0.1 2017/4/14 18:45 Ian.Su Exp $
 */
public interface RaCacheMapper {

    void save(@Param("id") String id,@Param("val") String val,@Param("validDate") Date validDate);

    String get(@Param("id") String id);

    void clean(@Param("validDate") Date validDate);
}
