package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.BlackFocusNumDTO;
import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.vo.RaBlackListFocusVO;
import com.bbd.dafei.common.util.PageInfo;

import java.util.List;

/**
 * Created by tuanhong on 2017-04-23.
 */
public interface RaBlackListFocusService {


    public List<RaBlackListFocusVO> findByUsernameForExport(String username) throws Exception;


    /**
     * 根据用户统计关注企业数
     */
    int countFocusByUserId(String username);


    /**
     * 分页查询关注/备注/黑名单企业
     */
    PageInfo queryRiskChange(String username, PageInfo p);

    /**
     * 根据用户名、公司id、区域查询拉黑和关注信息
     *
     * @param companyId 公司id
     * @param userName  用户名
     * @param province  区域
     * @return
     */
    BlackFocusNumDTO findBlackAndFocusNum(String companyId, String userName, String province);

    /**
     * 根据id设置关注企业中有风险变动的企业的状态为已查看
     *
     * @param id
     * @return
     */
    void updateLookOverById(Integer id);

    /**
     * 设置所有关注企业中有风险变动的企业的状态为未查看
     *
     * @param status
     * @return
     */
    void updateLookOver(Integer status);


    /**
     * 分页查询我的关注列表
     *
     * @param p 分页信息
     */

    PageInfo queryMyFocus(PageInfo p, int type, String username, String industry, String riskLevel, String order, String descAsc);


    /**
     * 根据id和类型删除数据
     *
     * @param id PK
     */
    void cancelFocus(Integer id,Integer blackChangeLook);


    /**
     * 统计我加入黑名单的企业数
     */
    int countBlackByUserId(String username);

    /**
     * 将企业加入我的关注
     */
    void addFocus(String username, String companyId, String companyName, List<KeyValDTO<Integer, String>> addReasons);




    /**
     * 查看被加入黑名单而取消关注的企业的状态
     * @param id 关注ID
     * */
    void lookBlackChangeCancelFoucs(Integer id);



}
