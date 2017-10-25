package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.modal.dto.RaReportDetailDTO;
import com.bbd.dafei.common.util.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by tuanhong on 2017-04-21.
 */
public interface RaReportDetailMapper {


    void save(RaReportDetailDTO raReportDetailDTO);

    int getStatusByUserIdAndCompany(@Param("userId") int userId, @Param("company") String company, @Param("reportStatus") String reportStatus);

    int getStatusByUserIdAndCompanyId(@Param("userId") int userId, @Param("companyId") String companyId, @Param("reportStatus") String reportStatus);

    String findApplyTimeByUserIdAndCompany(@Param("userId") int userId, @Param("company") String company, @Param("reportStatus") String reportStatus);

    /**
     * 查询最新的研报申请记录状态
     *
     * @param userId
     * @param companyId
     * @return
     */
    String findLastReportStatus(@Param("userId") int userId, @Param("companyId") String companyId);

    /**
     * 更新研报申请状态
     *
     * @param newStatus
     * @param gmtUpdate
     * @param userId
     * @param company
     * @param oldStatus
     */
    void updateReportStatusByUserIdAndCompany(@Param("newStatus") String newStatus,
                                              @Param("gmtUpdate") Date gmtUpdate,
                                              @Param("fileType") String fileType,
                                              @Param("userId") int userId,
                                              @Param("company") String company,
                                              @Param("oldStatus") String oldStatus);

    /**
     * 更新研报下载时间
     *
     * @param newStatus
     * @param gmtUpdate
     * @param userId
     * @param companyId
     */
    void updateDownTime(@Param("newStatus") String newStatus,
                        @Param("gmtUpdate") Date gmtUpdate,
                        @Param("userId") int userId,
                        @Param("companyId") String companyId,
                        @Param("applyTime") String applyTime);

    /**
     * 取得上传研报的文件类型
     *
     * @param reportId
     * @return
     */
//    String findFileType(@Param("userId") int userId, @Param("companyId") String companyId, @Param("applyTime") String applyTime);
    String findFileType(@Param("reportId") int reportId);
    /**
     * 取得上传研报的reportUrl
     *
     * @param reportId
     * @return
     */
    String findReportUrl(@Param("reportId") int reportId);

    /**
     * 取得研报总数
     *
     * @return
     */
    int count();

    /**
     * 分页查询
     *
     * @param page 包含分页信息
     * @return
     */
    List<RaReportDetailDTO> query(@Param("page") PageInfo page);


    /**
     * 修改研报
     */
    void updateReportStatusById(@Param("id") Integer id,
                                @Param("reportUrl") String reportUrl,
                                @Param("newStatus") String newStatus,
                                @Param("fileType") String fileType,
                                @Param("userId") int userId);
}
