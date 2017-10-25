package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.RaReportDetailDTO;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.PageInfoIgnore;

import java.util.Date;
import java.util.Map;

/**
 * Created by tuanhong on 2017-04-21.
 */
public interface RaReportDetailService {
    /**
     * 申请产生研报
     *
     * @param userId
     * @param username
     * @param companyId
     * @param company
     * @return
     * @throws Exception
     */
    Map<String, String> applyResearch(int userId, String username, String companyId, String company) throws Exception;

    /**
     * 查询最新的研报申请记录状态
     *
     * @param userId
     * @param companyId
     * @return
     */
    String findLastReportStatus(int userId, String companyId);

    /**
     * 查询研报的申请时间
     *
     * @param userId
     * @param company
     * @param reportStatus
     * @return
     */
    String findApplyTimeByUserIdAndCompany(int userId, String company, String reportStatus);

    /**
     * 更新研报申请状态
     *
     * @param newStatus
     * @param gmtUpdate
     * @param fileType
     * @param userId
     * @param company
     * @param oldStatus
     */
    void updateReportStatusByUserIdAndCompany(String newStatus, Date gmtUpdate, String fileType, int userId, String company, String oldStatus);

    /**
     * 更新研报下载时间
     *
     * @param newStatus
     * @param gmtUpdate
     * @param userId
     * @param companyId
     * @param applyTime
     */
    void updateDownTime(String newStatus, Date gmtUpdate, int userId, String companyId, String applyTime);

    /**
     * 取得研报上传文件类型
     *
     * @param reportId
     */
    String findFileType(int reportId);

    /**
     * @param reportId
     * @return
     */
    String findReportUrl(int reportId);

    /**
     * 查询研报
     *
     * @param page 分页信息
     * @return
     */
    PageInfo<RaReportDetailDTO> query(PageInfoIgnore page);


    /**
     * 研报上传
     *
     * @param id
     * @param reportUrl
     * @param newStatus
     * @param fileType
     * @param userId
     * @return void
     */
    void updateReportStatusById(Integer id, String reportUrl, String newStatus, String fileType, int userId);
}
