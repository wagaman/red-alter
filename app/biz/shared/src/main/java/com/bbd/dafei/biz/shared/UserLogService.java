package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.UserInfo;
import com.bbd.dafei.common.modal.dto.UserLogDTO;
import com.bbd.dafei.common.util.PageInfo;

import java.util.List;

/**
 * 用户日志service
 * Created by wish on 2017/4/18.
 */
public interface UserLogService {
    /**
     * 保存用户日志
     *
     * @param userLogDTO
     */
    void saveUserLog(UserLogDTO userLogDTO);

    /**
     * 保存登录日志
     *
     * @param userPO
     * @param userInfo
     */
    void saveLoginLog(UserPO userPO, UserInfo userInfo);

    /**
     * 分页条件查询用户日志
     *
     * @param userName  用户名
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param page      页
     * @param pageSize  每页条数
     * @param pageType  页面类型
     * @return
     */
    PageInfo<UserLogDTO> findUserLogPage(String userName, String startDate, String endDate, String pageType, int page, int pageSize);

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
    List<UserLogDTO> findLogsByIds(List<Integer> logIds);
}
