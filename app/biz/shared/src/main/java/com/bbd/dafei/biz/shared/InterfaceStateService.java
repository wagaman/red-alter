package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.dal.po.InterfaceStatePO;

import java.util.List;

public interface InterfaceStateService {

    String findById(InterfaceStatePO statePO,String appGuid);


    List<InterfaceStatePO> findAllInterface();
}
