package com.bbd.dafei.biz.shared;


import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.UserDTO;
import com.bbd.dafei.common.util.PageInfo;

import java.util.List;

/**
 * 用户service
 * Created by tuanhong on 2017/4/17.
 */
public interface UserService {
    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return UserPO
     */
    public UserPO findByName(String username);

    /**
     * 根据盐值对密码进行加密
     *
     * @param password
     * @param salt
     * @return String
     */
    String getPasswrodForMD5(String password, String salt);

    /**
     * 添加前台用户
     *
     * @param userDTO
     */
    void addFrontUser(UserDTO userDTO);

    /**
     * 修改前台用户
     *
     * @param userDTO
     */
    void updateFrontUser(UserDTO userDTO);

    /**
     * 添加后台用户
     *
     * @param userDTO
     */
    void addManageUser(UserDTO userDTO);

    /**
     * 修改后台用户
     *
     * @param userDTO
     */
    void updateManageUser(UserDTO userDTO);

    /**
     * 根据id批量注销用户
     *
     * @param ids      用户id集合
     * @param updateBy 操作人
     */
    void updateLogoutBatchByIds(List<Integer> ids, String updateBy);

    /**
     * 分页条件查询前台用户
     *
     * @param userName 用户名
     * @param province 省份
     * @param page     页
     * @param pageSize 每页条数
     * @return
     */
    PageInfo<UserDTO> findFrontUserInfoListPage(String userName, String province, int page, int pageSize);

    /**
     * 分页条件查询后台用户
     *
     * @param userName 用户名
     * @param page     页
     * @param pageSize 每页条数
     * @return
     */
    PageInfo<UserPO> findManageUserInfoListPage(String userName, int page, int pageSize);

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    UserDTO findUserInfoById(Integer id);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    UserPO findUserById(Integer id);

    /**
     * 根据用户名查询前台用户
     * @param userName
     * @return
     */
    UserPO findFrontUserByName(String userName);

    /**
     * 根据用户名查询后台用户
     * @param userName
     * @return
     */
    UserPO findManageUserByName(String userName);
}
