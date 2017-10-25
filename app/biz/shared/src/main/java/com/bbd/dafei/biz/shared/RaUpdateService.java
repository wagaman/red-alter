package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.RaUpdateDTO;

/**
 * 更正企业信息service
 * Created by tuanhong on 2017-04-20.
 */
public interface RaUpdateService {
    /**
     * 新增企业更正信息
     * @param raUpdateDTO
     */
    public void insertCompanyInfo(RaUpdateDTO raUpdateDTO) throws Exception;
}
