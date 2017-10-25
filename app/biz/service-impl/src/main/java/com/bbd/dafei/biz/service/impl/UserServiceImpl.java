package com.bbd.dafei.biz.service.impl;


import com.bbd.dafei.biz.shared.RaResearchReportService;
import com.bbd.dafei.biz.shared.UserService;
import com.bbd.dafei.common.dal.mapper.LoginMapper;
import com.bbd.dafei.common.dal.mapper.RaUserMapper;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.modal.dto.UserDTO;
import com.bbd.dafei.common.modal.dto.UserInfo;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.MD5Util;
import com.bbd.dafei.common.util.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by tuanhong on 2017/4/17.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private RaUserMapper userMapper;

    @Autowired
    private RaResearchReportService researchReportService;

    @Override
    public UserPO findByName(String username) {
        return loginMapper.findByName(username);
    }

    @Override
    public String getPasswrodForMD5(String password, String salt) {
        String newPassword = null;
        try {
            newPassword = MD5Util.MD5(password + "=" + salt);
        } catch (NoSuchAlgorithmException e) {
            logger.error("密码加密失败", e);
        }
        return newPassword;
    }

    public void addFrontUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new CommonException("保存用户失败，用户不能为空");
        }
        //验证用户名是否存在
        UserPO u = userMapper.findUserByName(userDTO.getUsername());
        if (u != null) {
            throw new CommonException("用户名已存在");
        }
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(userDTO, userPO);
        //密码加密
        String salt = StringUtils.substringBefore(UUID.randomUUID().toString(), "-");
        userPO.setPassword(getPasswrodForMD5(userPO.getPassword(), salt));
        userPO.setSalt(salt);
        userPO.setType(Constants.USER_TYPE_FRONT);
        userMapper.insertUser(userPO);

        //保存剩余下载次数到协议
        researchReportService.updateResearchReportRemain(userPO.getId(), userDTO.getResearchReportRemainTimes());
    }

    @Override
    public void updateFrontUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new CommonException("修改用户失败，用户不能为空");
        }
        UserPO userPO = userMapper.findUserById(userDTO.getId());
        if (userPO == null) {
            throw new CommonException("修改用户失败，该用户不存在");
        }

        userPO.setTel(userDTO.getTel());
        userPO.setEmail(userDTO.getEmail());
        userPO.setProvince(userDTO.getProvince());
        userPO.setUpdateBy(userDTO.getUpdateBy());
        userPO.setRemark(userDTO.getRemark());
        userPO.setValidDate(userDTO.getValidDate());
        //如果新传入的密码与旧密码不一致，认为是新设置的密码，进行加密
        if (!StringUtils.equals(userPO.getPassword(), userDTO.getPassword())) {
            //密码加密
            String salt = StringUtils.substringBefore(UUID.randomUUID().toString(), "-");
            userPO.setPassword(getPasswrodForMD5(userDTO.getPassword(), salt));
            userPO.setSalt(salt);
        }
        userMapper.updateFrontUser(userPO);

        //保存剩余下载次数到协议
        researchReportService.updateResearchReportRemain(userPO.getId(), userDTO.getResearchReportRemainTimes());
    }

    @Override
    public void addManageUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new CommonException("保存用户失败，用户不能为空");
        }
        //验证用户名是否存在
        UserPO u = userMapper.findUserByName(userDTO.getUsername());
        if (u != null) {
            throw new CommonException("用户名已存在");
        }
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(userDTO, userPO);
        //密码加密
        String salt = StringUtils.substringBefore(UUID.randomUUID().toString(), "-");
        userPO.setPassword(getPasswrodForMD5(userPO.getPassword(), salt));
        userPO.setSalt(salt);
        userPO.setType(Constants.USER_TYPE_MANAGE);
        userMapper.insertUser(userPO);
    }

    @Override
    public void updateManageUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new CommonException("修改用户失败，用户不能为空");
        }
        UserPO userPO = userMapper.findUserById(userDTO.getId());
        if (userPO == null) {
            throw new CommonException("修改用户失败，该用户不存在");
        }
        userPO.setUpdateBy(userDTO.getUpdateBy());
        userPO.setRemark(userDTO.getRemark());
        //如果新传入的密码与旧密码不一致，认为是新设置的密码，进行加密
        if (!StringUtils.equals(userPO.getPassword(), userDTO.getPassword())) {
            //密码加密
            String salt = StringUtils.substringBefore(UUID.randomUUID().toString(), "-");
            userPO.setPassword(getPasswrodForMD5(userDTO.getPassword(), salt));
            userPO.setSalt(salt);
        }
        userMapper.updateManageUser(userPO);
    }

    @Override
    public void updateLogoutBatchByIds(List<Integer> ids, String updateBy) {
        int updateNum = userMapper.updateLogoutBatchByIds(ids, updateBy);
        if (updateNum < 1) {
            throw new CommonException("注销用户失败");
        }
    }

    @Override
    public PageInfo<UserDTO> findFrontUserInfoListPage(String userName, String province, int page, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, pageSize);
        params.put("page", pageInfo);
        params.put("userName", userName);
        params.put("province", province);
        List<UserDTO> userLogDTOList = userMapper.findFrontUserInfoListPage(params);
        pageInfo.setItems(userLogDTOList);
        return pageInfo;
    }

    public PageInfo<UserPO> findManageUserInfoListPage(String userName, int page, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, pageSize);
        params.put("page", pageInfo);
        params.put("userName", userName);
        List<UserPO> userLogDTOList = userMapper.findManageUserInfoListPage(params);
        pageInfo.setItems(userLogDTOList);
        return pageInfo;
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public UserDTO findUserInfoById(Integer id) {
        return userMapper.findUserInfoById(id);
    }

    public UserPO findUserById(Integer id) {
        return userMapper.findUserById(id);
    }


    @Override
    public UserPO findFrontUserByName(String userName) {
        return userMapper.findUserByNameAndType(userName, Constants.USER_TYPE_FRONT);
    }

    @Override
    public UserPO findManageUserByName(String userName) {
        return userMapper.findUserByNameAndType(userName, Constants.USER_TYPE_MANAGE);
    }


}
