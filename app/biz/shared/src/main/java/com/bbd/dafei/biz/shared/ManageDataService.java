package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.*;
import com.bbd.dafei.common.util.PageInfo;

/**
 * Created by wish on 2017/4/19.
 */
public interface ManageDataService {
    /**
     * 根据公司id查询工商变更信息
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @param highLight 是否高亮
     * @return
     * @throws Exception
     */
    PageInfo<BgxxDTO> getBgxxByCompanyId(String companyId, Integer page, Integer pageSize, boolean highLight) throws Exception;

    /**
     * 根据公司id查询舆情信息
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<YuqingDTO> getYuqingByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 根据公司id查询域名备案
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<YmbaDTO> getYmbaBycompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 根据公司id查询年报
     *
     * @param companyId
     * @return
     * @throws Exception
     */
    YearReportDTO getYearReportByCompanyId(String companyId) throws Exception;

    /**
     * 根据公司id查询招聘数据信息
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<RecruitDTO> getRecruitBycompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 查询招聘KPI
     *
     * @param companyId 公司id
     * @return
     * @throws Exception
     */
    RecruitKPIDTO getRecruitKPIByCompanyId(String companyId) throws Exception;


}
