package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.dal.po.RaCompanyPO;

/**
 * Created by tuanhong on 2017-09-06.
 */
public interface RaAreaCountService {

    /**
     * 更新统计数据
     * @param raCompanyPO
     * @param columnValue
     */
    void updateAreaCountNum(RaCompanyPO raCompanyPO,int columnValue);
}
