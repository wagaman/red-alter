package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.dal.po.UserPO;

/**
 * Created by tuanhong on 2017-04-19.
 */
public interface LoginMapper {
    UserPO findByName(String username);
}
