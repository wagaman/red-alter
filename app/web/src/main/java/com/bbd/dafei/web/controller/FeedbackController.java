package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.RaFeedbackService;
import com.bbd.dafei.common.annotation.UserLog;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ian.Su
 * @version $Id: FeedbackController.java, v 0.1 2017/5/4 18:40 Ian.Su Exp $
 */

@Api(value = "/feedback", tags = "意见反馈")
@RestController
@RequestMapping("/feedback")
public class FeedbackController extends BaseController {

    @Autowired
    private RaFeedbackService feedbackService;

    @RequestMapping(value = "/add.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "添加反馈信息", notes = "添加反馈信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "feedback", value = "反馈信息", required = true, paramType = "query", dataType = "String")
    })
    @UserLog
    public ResponseBean<String> add(@RequestParam String feedback) {

        feedbackService.insert(getSessionUser().getUsername(), feedback);

        return ResponseBean.successResponse("反馈信息已提交成功");

    }

}