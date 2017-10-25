package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.RaUpdateService;
import com.bbd.dafei.common.dal.mapper.RaUpdateMapper;
import com.bbd.dafei.common.modal.dto.RaUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tuanhong on 2017-04-20.
 */
@Service
public class RaUpdateServiceImpl implements RaUpdateService {

    @Autowired
    private RaUpdateMapper raUpdateMapper;

    @Override
    public void insertCompanyInfo(RaUpdateDTO raUpdateDTO) throws Exception {
        this.raUpdateMapper.saveRaUpdateInfo(raUpdateDTO);
    }
}
