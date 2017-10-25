package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.ExchangeDTO;
import com.bbd.dafei.common.modal.dto.PlatformDTO;
import com.bbd.dafei.common.modal.dto.PrivateFundDTO;

/**
 * 企业特征信息Service
 * Created by wish on 2017/4/25.
 */
public interface FeatureService {
    /**
     * 根据公司id查询交易信息
     *
     * @param companyId 公司id
     * @return
     * @throws Exception
     */
    ExchangeDTO getExchangeByCompanyId(String companyId) throws Exception;

    /**
     * 根据公司id查询私募基金特征信息
     *
     * @param companyId 公司id
     * @return
     * @throws Exception
     */
    PrivateFundDTO getPrivateFundBycompanyId(String companyId) throws Exception;

    /**
     * 根据公司id查询网络借贷特征信息
     *
     * @param companyId
     * @return
     * @throws Exception
     */
    PlatformDTO getP2PPlatformByCompanyId(String companyId) throws Exception;

}
