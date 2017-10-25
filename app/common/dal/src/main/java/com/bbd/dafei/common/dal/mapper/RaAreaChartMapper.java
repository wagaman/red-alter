package com.bbd.dafei.common.dal.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * 区域相关图表统计表
 * @author anhong.Tu
 * @version $Id: RaAreaChartMapper.java, v 0.1 2017/7/6 10:10 anhong.Tu Exp $
 */
public interface RaAreaChartMapper {

    String getNetAvgReturnRate(@Param("province") String province,@Param("city") String city,@Param("area") String area);

    String getNetAvgLoanDate(@Param("province") String province,@Param("city") String city,@Param("area") String area);

    String getTradePlaceType(@Param("province") String province,@Param("city") String city,@Param("area") String area);

    String getTradePlaceTradeType(@Param("province") String province,@Param("city") String city,@Param("area") String area);

    String getHighCompanySort(@Param("industry") String industry,@Param("province") String province,@Param("city") String city,@Param("area") String area);

    String getPrivateFundProductNum(@Param("province") String province,@Param("city") String city,@Param("area") String area);

    String getPrivateFundProductType(@Param("province") String province,@Param("city") String city,@Param("area") String area);

    String getPrivateFundCompanyType(@Param("province") String province,@Param("city") String city,@Param("area") String area);

    String getPrivateFundEmployeeScale(@Param("province") String province,@Param("city") String city,@Param("area") String area);
}
