package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.vo.MyReportPageInfoListVO;
import com.bbd.dafei.common.util.Paging;

/**
 * Created by tuanhong on 2017-04-24.
 */
public interface MyReportService {
    /**
     *
     * 根据用户ID查分页查询报告相关信息
     *
     * */
    public Paging<MyReportPageInfoListVO> query(int userId, String username,Integer start, Integer size) throws Exception;

    /**
     * 查询客户研报未下载的总数量
     * @param userId
     * @param reportStatus
     * @return
     */
    public int queryCount(int userId, String reportStatus);

    /**
     * 查询客户研报申请时间
     * @param userId
     * @param companyId
     * @param reportStatus
     * @return
     */
    public String getApplyTime(int userId, String companyId,String reportStatus);

    /**
     * 查询客户研报申请时间
     * @param userId
     * @param companyId
     * @param reportStatus
     * @return
     */
    public String getMaxApplyTime(int userId, String companyId,String reportStatus);
}
