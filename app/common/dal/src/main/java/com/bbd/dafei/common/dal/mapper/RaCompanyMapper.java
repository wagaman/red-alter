package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.modal.vo.RaCompanyVO;
import com.bbd.dafei.common.modal.vo.RaIndexCompanyVO;
import com.bbd.dafei.common.util.PageInfoIgnore;
import org.apache.ibatis.annotations.Param;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by tuanhong on 2017-04-23.
 */
public interface RaCompanyMapper {

    RaCompanyVO getRadarByCompany(String company);

    RaCompanyVO getScanByCompany(String company);

    RaCompanyVO getSortByCompany(String company);

    RaCompanyVO getRadarByCompanyId(String companyId);

    RaCompanyVO getScanByCompanyId(String companyId);

    RaCompanyVO getSortByCompanyId(String companyId);

    int count(@Param("province")String province,@Param("industry")String industry,@Param("city") String city,@Param("area") String area);

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
    List<RaCompanyPO> findCompanysByIds(@Param("companyIds") Set<String> companyIds);


    /**
     *
     * 根据关键字搜索企业
     *
     * */
    List<RaCompanyPO> search(@Param("page")PageInfoIgnore page,
                             @Param("keyword")String keyword);


    /**
     *
     * 根据关键字统计搜索企业数量
     *
     * */
    int searchCount( @Param("keyword")String keyword);

    /**
     * 根据行业取得重点关注 和持续监控企业数
     * @param province
     * @param city
     * @param area
     * @param industry
     * @return
     */
    int industryCount(@Param("province") String province,@Param("city") String city,@Param("area") String area,@Param("industry") String industry,@Param("riskLevel") String riskLevel);

    /**
     * 分页查询公司信息
     * @param map
     * @return
     */
    List<RaIndexCompanyVO> findIndexCompanyPage(@Param("map") Map<String,Object> map);

    /**
     * 根据Id更新isBlack栏位值
     * @param companyIds
     * @param isBlackValue
     */
    void updateIsBlackById(@Param("companyIds") Set<String> companyIds,@Param("isBlackValue") int isBlackValue);
}
