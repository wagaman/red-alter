package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.modal.vo.RaCompanyVO;
import com.bbd.dafei.common.modal.vo.RaIndexCompanyVO;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.PageInfoIgnore;

import java.util.List;
import java.util.Set;

/**
 * Created by tuanhong on 2017-04-23.
 */
public interface RaCompanyService {

    /**
     * 查询易燃指数雷达图
     * @param company
     * @return
     * @throws Exception
     */
    public RaCompanyVO getRadarByCompany(String company) throws Exception;

    /**
     * 查询易燃指数雷达图
     * @param companyId
     * @return
     * @throws Exception
     */
    public RaCompanyVO getRadarByCompanyId(String companyId) throws Exception;

    /**
     * 查询风险提示
     */
    public RaCompanyVO getScanByCompany(String company) throws Exception;

    /**
     * 查询风险提示
     * @param companyId
     * @return
     * @throws Exception
     */
    public RaCompanyVO getScanByCompanyId(String companyId) throws Exception;

    /**
     * 查询易燃指数时序图
     */
    public RaCompanyVO getSortByCompany(String company) throws Exception;

    /**
     * 查询易燃指数时序图
     * @param companyId
     * @return
     * @throws Exception
     */
    public RaCompanyVO getSortByCompanyId(String companyId) throws Exception;

    /**
     * 根据名称查询公司风险信息
     *
     * @param companyName
     * @return
     */
    RaCompanyPO findCompanyByName(String companyName);

    /**
     * 根据id查询公司风险信息
     *
     * @param companyId
     * @return
     */
    RaCompanyPO findCompanyById(String companyId);

    /**
     * 根据id批量查询公司风险信息
     *
     * @param companyIds
     * @return
     */
    List<RaCompanyPO> findCompanysByIds(Set<String> companyIds);


    /**
     * 分页搜索企业
     *
     * @param keyword 企业名称关键字
     * @return PageInfo<RaCompanyPO>
     */
    PageInfo<RaCompanyPO> search(PageInfoIgnore page, String keyword);

    /**
     * 根据关键字搜索企业
     *
     * @param keyword 企业名称关键字
     * @return List<RaCompanyPO>
     */
    List<RaCompanyPO> search(String keyword);

    /**
     * 分页查询公司
     * @param province
     * @param city
     * @param area
     * @param industry
     * @param riskLevel
     * @param page
     * @param pageSize
     * @param order
     * @param descAsc
     * @return
     */
    PageInfo<RaIndexCompanyVO> findIndexCompanyPage(String province, String city,
                                     String area, String industry, String riskLevel,
                                     Integer page, Integer pageSize,
                                     String order, String descAsc);
}
