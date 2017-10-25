package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.RaSimpleDetailService;
import com.bbd.dafei.common.dal.mapper.RaSimpleDetailMapper;
import com.bbd.dafei.common.modal.dto.RaSimpleDetailDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tuanhong on 2017-05-10.
 */
@Service
public class RaSimpleDetailServiceImpl implements RaSimpleDetailService {

    @Autowired
    private RaSimpleDetailMapper raSimpleDetailMapper;

    @Override
    public void save(RaSimpleDetailDTO raSimpleDetailDTO) throws Exception {
        raSimpleDetailMapper.save(raSimpleDetailDTO);
    }
}
