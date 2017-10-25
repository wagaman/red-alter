package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.*;
import com.bbd.dafei.common.modal.vo.BaseDataVO;
import com.bbd.dafei.common.util.PageInfo;

/**
 * Created by wish on 2017/4/17.
 */
public interface BaseDataService {

    /**
     * 根据公司id查询基本信息
     *
     * @param companyId
     * @return
     * @throws Exception
     */
    BaseDataVO getBaseDataByCompanyId(String companyId) throws Exception;

    /**
     * 根据公司id查询海外分支机构
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<OverseasInvestDTO> getOverseasInvestByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 根据公司名查询基本信息
     *
     * @param companyName 公司名
     * @return
     * @throws Exception
     */
    JbxxDTO getJbxxByCompanyName(String companyName) throws Exception;

    /**
     * 根据公司id查询基本信息概览，包含邮箱、网址、电话
     *
     * @param companyId 公司id
     * @return
     * @throws Exception
     */
    BaseDataOverviewDTO getBaseDataOverviewByCompanyId(String companyId) throws Exception;

    /**
     * 根据公司id查询基本信息摘要，包含分支机构数和分公司数
     *
     * @param companyId
     * @return
     * @throws Exception
     */
    BaseDataAbstractDTO getBaseDataAbstractByCompanyId(String companyId) throws Exception;

    /**
     * 根据公司id查询分支机构
     *
     * @param companyId
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<FzjgDTO> getFzjgByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception;


}
