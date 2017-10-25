package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.RaTimeSqueService;
import com.bbd.dafei.common.dal.mapper.RaTimeSqueMapper;
import com.bbd.dafei.common.modal.vo.RaTimeSqueVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tuanhong on 2017-05-11.
 */
@Service
public class RaTimeSqueServiceImpl implements RaTimeSqueService {
    @Autowired
    private RaTimeSqueMapper raTimeSqueMapper;
    @Override
    public List<RaTimeSqueVO> getTimeSqueInfo(String industry) {
        return raTimeSqueMapper.getTimeSqueInfo(industry);
    }
}
