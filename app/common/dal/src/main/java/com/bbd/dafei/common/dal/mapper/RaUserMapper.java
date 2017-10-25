package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.UserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户mapper
 * Created by wish on 2017/5/25.
 */
public interface RaUserMapper {
    /**
     * 添加用户
     *
     * @param userPO
     */
    void insertUser(UserPO userPO);

    /**
     * 修改前台用户信息
     *
     * @param userPO
     */
    void updateFrontUser(UserPO userPO);

    /**
     * 修改后台用户信息
     * @param userPO
     */
    void updateManageUser(UserPO userPO);

    /**
     * 根据id批量注销用户
     *
     * @param ids      用户id集合
     * @param updateBy 操作人
     */
    int updateLogoutBatchByIds(@Param("ids") List<Integer> ids, @Param("updateBy") String updateBy);


    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    UserPO findUserById(Integer id);

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    UserPO findUserByName(String userName);

    /**
     * 分页条件查询前台用户
     *
     * @param params
     * @return
     */
    List<UserDTO> findFrontUserInfoListPage(@Param("map") Map<String, Object> params);

    /**
     * 分页条件查询后台用户
     * @param params
     * @return
     */
    List<UserPO> findManageUserInfoListPage(@Param("map") Map<String, Object> params);

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    UserDTO findUserInfoById(Integer id);

    /**
     * 根据用户名和用户类型查询用户
     * @param userName 用户名
     * @param type 类型
     * @return
     */
    UserPO findUserByNameAndType(@Param("userName") String userName,@Param("type") Integer type);
}
