package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.vo.FeedbackVO;
import com.bbd.dafei.common.util.PageInfo;

/**
 * 多表信息反馈
 *
 * @author Ian.Su
 * @version $Id: MultiFeedbackService.java, v 0.1 2017/5/27 10:52 Ian.Su Exp $
 */
public interface MultiFeedbackService {


    /**
     * 分页查询所有反馈信息
     */
    PageInfo<FeedbackVO> query(String user, String type, String startDate, String endDate, int page, int pageSize);

}
