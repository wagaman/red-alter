package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.RaProblemPlatformService;
import com.bbd.dafei.common.dal.mapper.RaProblemPlatformMapper;
import com.bbd.dafei.common.modal.dto.RaProblemPlatformDTO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by wish on 2017/5/5.
 */
@Service
public class RaProblemPlatformServiceImpl implements RaProblemPlatformService{

    @Autowired
    private RaProblemPlatformMapper raProblemPlatformMapper;

    /**
     * 根据平台名称查询问题平台信息
     * @param name 平台名称
     * @return
     */
    @Override
    public RaProblemPlatformDTO findProblemPlatformByName(String name) {
        return raProblemPlatformMapper.findProblemPlatformByName(name);
    }

    @Override
    public List<RaProblemPlatformDTO> findProblemPlatformsByNames(Set<String> names) {
        if(CollectionUtils.isEmpty(names)) {
            return new ArrayList<>();
        }
        return raProblemPlatformMapper.findProblemPlatformsByNames(names);
    }
}
