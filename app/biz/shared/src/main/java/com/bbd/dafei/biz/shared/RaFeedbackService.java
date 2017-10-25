package com.bbd.dafei.biz.shared;

/**
 * 意见反馈
 * @author Ian.Su
 * @version $Id: RaFeedbackService.java, v 0.1 2017/5/4 18:36 Ian.Su Exp $
 */
public interface RaFeedbackService {


    /**
     *  添加反馈信息
     *  @param feedback  反馈内容
     *  @param username  反馈用户
     * */
    void insert(String username,String feedback);

}
