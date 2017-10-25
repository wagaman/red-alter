package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.dal.po.RaResearchReportPO;

/**
 * Created by tuanhong on 2017-04-21.
 */
public interface RaResearchReportMapper {

    RaResearchReportPO findByUserId(int userId);

    int updateRemTimeAndUsedTimeById(RaResearchReportPO raResearchReportPO);

    /**
     * 统计已下载和已申请下载总数
     */
    int countDoneAndApply(Integer userId);

    void insertRaResearchReport(RaResearchReportPO raResearchReportPO);

    void deleteRaResearchReport(int userId);
}
