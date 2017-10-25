package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.UserLogService;
import com.bbd.dafei.common.dal.mapper.UserLogMapper;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.UserInfo;
import com.bbd.dafei.common.modal.dto.UserLogDTO;
import com.bbd.dafei.common.util.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wish on 2017/4/18.
 */
@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogMapper userLogMapper;

    @Override
    public void saveUserLog(UserLogDTO userLogDTO) {
        userLogMapper.saveUserLog(userLogDTO);
    }

    @Override
    public void saveLoginLog(UserPO userPO, UserInfo userInfo) {
        if (userPO == null) {
            return;
        }
        UserLogDTO userLogDTO = new UserLogDTO();
        userLogDTO.setUserName(userPO.getUsername());
        userLogDTO.setPage("登录");
        userLogDTO.setOperation("用户登录");
        userLogDTO.setUrl("");
        userLogDTO.setDetail("账号登录时间:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        if (userInfo != null) {
            userLogDTO.setIp(userInfo.getIp());
            userLogDTO.setIpLocation(userInfo.getIpLocation());
        }
        userLogMapper.saveUserLog(userLogDTO);
    }

    @Override
    public PageInfo<UserLogDTO> findUserLogPage(String userName, String startDate, String endDate, String pageType, int page, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, pageSize);
        params.put("page", pageInfo);
        params.put("userName", userName);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        params.put("pageType", pageType);
        List<UserLogDTO> userLogDTOList = userLogMapper.findUserLogPage(params);
        pageInfo.setItems(userLogDTOList);
        return pageInfo;
    }

    @Override
    public List<String> findAllPageType() {
        return userLogMapper.findAllPageType();
    }

    /**
     * 根据id集合批量查询日志
     *
     * @param logIds
     * @return
     */
    @Override
    public List<UserLogDTO> findLogsByIds(@Param("logIds") List<Integer> logIds) {
        if (CollectionUtils.isEmpty(logIds)) {
            return new ArrayList<>();
        }
        return userLogMapper.findLogsByIds(logIds);
    }
}
