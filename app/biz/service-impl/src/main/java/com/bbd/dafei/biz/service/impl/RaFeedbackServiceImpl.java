package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.RaFeedbackService;
import com.bbd.dafei.common.dal.mapper.RaFeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ian.Su
 * @version $Id: RaFeedbackServiceImpl.java, v 0.1 2017/5/4 18:37 Ian.Su Exp $
 */
@Service
public class RaFeedbackServiceImpl implements RaFeedbackService {

    @Autowired
    private RaFeedbackMapper feedbackMapper;

    @Override
    public void insert(String username, String feedback) {

        feedbackMapper.insert(username,feedback);

    }

}
