package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.*;
import com.bbd.dafei.common.util.PageInfo;

/**
 * 信用信息service
 * Created by wish on 2017/4/20.
 */
public interface CreditService {

    /**
     * 根据公司id查询开庭公告
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<KtggDTO> getKtggByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 根据公司id查询裁判文书
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<CpwsDTO> getCpwsByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 根据公司id查询法院公告
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<FyggDTO> getFyggByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 根据公司id查询被执行人
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<BzxrDTO> getBzxrByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 根据公司id查询失信被执行人
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<SxbzxrDTO> getSxbzxrByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 根据公司id查询司法拍卖信息
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<SfpmDto> getSfpmByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 根据公司id查询经营异常
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<JyycDTO> getJyycByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 根据公司id查询欠税名单
     *
     * @param companyId 公司id
     * @param page      页码
     * @param pageSize  每页条数
     * @return
     * @throws Exception
     */
    PageInfo<QsmdDTO> getQsmdByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 查询清算信息
     *
     * @param companyId
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<QsxxDTO> getQsxxByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 查询股权出质信息
     *
     * @param companyId
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<SharesPawnDTO> getSharesPawn(String companyId, Integer page, Integer pageSize) throws Exception;

    /**
     * 查询动产抵押信息
     *
     * @param companyId
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<MortgageDetailDTO> getMortgageDetail(String companyId, Integer page, Integer pageSize) throws Exception;

}
