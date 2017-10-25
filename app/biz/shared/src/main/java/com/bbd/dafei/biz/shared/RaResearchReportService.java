package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.dal.po.RaResearchReportPO;

/**
 * Created by tuanhong on 2017-04-21.
 */
public interface RaResearchReportService {
    /**
     * 根据用户id查询研报信息
     *
     * @param userId 用户id
     * @return RaResearchReportPO
     */
    public RaResearchReportPO findByUserId(int userId) throws Exception;

    /**
     * 根据id更新研报
     *
     * @param raResearchReportPO
     * @return int
     */
    public int updateRemTimeAndUsedTimeById(RaResearchReportPO raResearchReportPO);

    /**
     * 统计已下载和已申请下载总数
     */
    public int countDoneAndApply(Integer userId);

    /**
     * 设置用户剩余次数,剩余次数为空,表示未签协议，删除协议
     *
     * @param userId
     * @param remainTimes
     */
    void updateResearchReportRemain(Integer userId, Integer remainTimes);
}
