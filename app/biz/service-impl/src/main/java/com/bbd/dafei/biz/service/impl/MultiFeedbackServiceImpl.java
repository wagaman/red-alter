package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.MultiFeedbackService;
import com.bbd.dafei.common.dal.mapper.MultiFeedbackMapper;
import com.bbd.dafei.common.modal.vo.FeedbackVO;
import com.bbd.dafei.common.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ian.Su
 * @version $Id: MultiFeedbackServiceImpl.java, v 0.1 2017/5/27 11:10 Ian.Su Exp $
 */
@Service
public class MultiFeedbackServiceImpl implements MultiFeedbackService {

    @Autowired
    private MultiFeedbackMapper feedbackMapper;

    @Override
    public PageInfo<FeedbackVO> query(String user, String type, String startDate, String endDate, int page, int pageSize) {

        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, pageSize);
        params.put("page", pageInfo);
        params.put("type", type);
        params.put("user", user);
        params.put("startDate", startDate);
        params.put("endDate", endDate);

        if ("关注".equals(type)) {
            pageInfo.setItems(feedbackMapper.queryFocusPage(params));
        } else if ("备注".equals(type)) {
            pageInfo.setItems(feedbackMapper.queryCompanyRemarkPage(params));
        } else if ("企业信息更新".equals(type)) {
            pageInfo.setItems(feedbackMapper.queryCompanyUpdatePage(params));
        } else if ("平台信息反馈".equals(type)) {
            pageInfo.setItems(feedbackMapper.queryFeedbackPage(params));
        } else {
            pageInfo.setItems(feedbackMapper.queryAllPage(params));
        }

        return pageInfo;
    }
}

