package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.vo.RaTimeSqueVO;

import java.util.List;

/**
 * Created by tuanhong on 2017-05-11.
 */
public interface RaTimeSqueService {
    /**
     * 根据行业类型取时序图值的中位数与平均数
     * @param industry
     * @return
     */
    List<RaTimeSqueVO> getTimeSqueInfo(String industry);
}
