package com.bbd.dafei.common.modal.util;

/**
 * Created by wish on 2017/5/14.
 */
public class CompanyPermissionUtil {
    public static final String CENTRAL_OFFICE = "总局";

    /**
     * 判断用户省份是否与公司省份在同一区域
     * 用户的省份带省市，如四川省。如果包含公司所在省，认为是在同一省份
     *
     * @param userProvince    用户所在省
     * @param companyProvince 公司所在省
     * @return
     */
    public static boolean hasPermission(String userProvince, String companyProvince) {
        //临时放开权限控制
        return true;
//        //处理异常数据，如果是总局，替换为北京
//        if (CENTRAL_OFFICE.equals(companyProvince)) {
//            companyProvince = "北京市";
//        }
//        //用户的省份带省市，如四川省。如果包含公司所在省，认为是在同一省份
//        return StringUtils.isNotBlank(userProvince) && StringUtils.contains(userProvince, companyProvince);
    }
}
