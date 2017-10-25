package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.modal.dto.RaUpdateDTO;

/**
 * Created by tuanhong on 2017-04-20.
 */
public interface RaUpdateMapper {
    /**
     * 保存更正企业信息
     */
    public void saveRaUpdateInfo(RaUpdateDTO raUpdateDTO);
}
