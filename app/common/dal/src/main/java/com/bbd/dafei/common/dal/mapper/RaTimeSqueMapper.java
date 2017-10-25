package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.modal.vo.RaTimeSqueVO;

import java.util.List;

/**
 * Created by tuanhong on 2017-05-11.
 */
public interface RaTimeSqueMapper {
    List<RaTimeSqueVO> getTimeSqueInfo(String industry);
}
