package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.RaCompanyRemarkDTO;

import java.util.List;

/**
 * 公司备注Service
 * Created by wish on 2017/5/2.
 */
public interface RaCompanyRemarkService {
    /**
     * 根据公司id、平台和用户名查询备注
     *
     * @param companyId 公司id
     * @param platform  平台
     * @param userName  用户名
     * @return
     */
    List<RaCompanyRemarkDTO> findRemarkByCompanyIdAndUserName(String companyId, String platform, String userName);

    /**
     * 根据id删除备注
     *
     * @param id
     */
    void deleteRemarkById(Integer id, String userName);

    /**
     * 保存备注
     *
     * @param companyId 公司id
     * @param platform
     * @param userName  用户名
     * @param remark    备注
     */
    void saveRemark(String companyId, String platform, String userName, String remark);
}
