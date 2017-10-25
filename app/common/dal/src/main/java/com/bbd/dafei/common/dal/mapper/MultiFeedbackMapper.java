package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.modal.vo.FeedbackVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Ian.Su
 * @version $Id: MultiFeedbackMapper.java, v 0.1 2017/5/27 11:11 Ian.Su Exp $
 */
public interface MultiFeedbackMapper {


    /**
     * 分页查询所有反馈信息
     */
    List<FeedbackVO> queryAllPage(@Param("map") Map<String, Object> map);

    /**
     * 分页查询黑名单信息
     */
    List<FeedbackVO> queryBlacklistPage(@Param("map") Map<String, Object> map);


    /**
     * 分页查询关注信息
     */
    List<FeedbackVO> queryFocusPage(@Param("map") Map<String, Object> map);

    /**
     * 分页查询企业备注信息
     */
    List<FeedbackVO> queryCompanyRemarkPage(@Param("map") Map<String, Object> map);

    /**
     * 分页查询企业信息更新
     */
    List<FeedbackVO> queryCompanyUpdatePage(@Param("map") Map<String, Object> map);

    /**git
     * 分页查询反馈信息
     *
     * @return
     */
    List<FeedbackVO> queryFeedbackPage(@Param("map") Map<String, Object> map);


}
