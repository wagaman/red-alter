package com.bbd.dafei.common.dal.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author Ian.Su
 * @version $Id: RaFeedbackMapper.java, v 0.1 2017/5/4 18:30 Ian.Su Exp $
 */
public interface RaFeedbackMapper {

    public void insert(@Param("username") String username,
                       @Param("feedback") String feedback);

}
