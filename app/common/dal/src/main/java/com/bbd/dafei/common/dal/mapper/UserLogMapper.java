package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.modal.dto.UserLogDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户日志mapper
 * Created by wish on 2017/4/18.
 */
public interface UserLogMapper {
    /**
     * 保存用户日志
     */
    void saveUserLog(UserLogDTO userLogDTO);

    /**
     * 分页查询用户日志
     *
     * @param params 查询参数
     * @return
     */
    List<UserLogDTO> findUserLogPage(@Param("map") Map<String, Object> params);

    /**
     * 查询所有页面类型
     *
     * @return
     */
    List<String> findAllPageType();

    /**
     * 根据id集合批量查询日志
     *
     * @param logIds
     * @return
     */
    List<UserLogDTO> findLogsByIds(@Param("logIds") List<Integer> logIds);
}
