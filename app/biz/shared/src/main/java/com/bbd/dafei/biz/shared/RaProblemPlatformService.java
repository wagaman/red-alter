package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.RaProblemPlatformDTO;

import java.util.List;
import java.util.Set;

/**
 * Created by wish on 2017/5/5.
 */
public interface RaProblemPlatformService {
    /**
     * 根据平台名称查询问题平台信息
     * @param name 平台名称
     * @return
     */
    RaProblemPlatformDTO findProblemPlatformByName(String name);

    /**
     * 根据平台名称批量查询问题平台信息
     * @param names
     * @return
     */
    List<RaProblemPlatformDTO> findProblemPlatformsByNames(Set<String> names);
}
