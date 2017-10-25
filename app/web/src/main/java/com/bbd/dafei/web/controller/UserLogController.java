package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.service.sys.UserLogThreadPool;
import com.bbd.dafei.biz.shared.UserLogService;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.UserInfo;
import com.bbd.dafei.common.modal.dto.UserLogDTO;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wish on 2017/6/6.
 */
@Controller
@RequestMapping("/userLog")
@Api(value = "/userLog", tags = "用户操作日志")
public class UserLogController extends BaseController {

    @Autowired
    private UserLogService userLogService;


    @RequestMapping(value = "save.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "保存用户操作日志", notes = "保存用户操作日志")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页面类型", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "operation", value = "使用日志", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "detail", value = "详情记录", required = true, paramType = "query", dataType = "String")
    })
    public ResponseBean save(HttpServletRequest request, String page, String operation, String detail) {
        UserLogDTO userLogDTO = new UserLogDTO();
        UserPO userPO = getSessionUser();
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_INFO);
        if (userPO != null) {
            userLogDTO.setUserName(userPO.getUsername());
        }
        if (userInfo != null) {
            userLogDTO.setIp(userInfo.getIp());
            userLogDTO.setIpLocation(userInfo.getIpLocation());
        }
        userLogDTO.setPage(page);
        userLogDTO.setOperation(operation);
        userLogDTO.setDetail(detail);
        //前端操作没有url，保存空字符串
        userLogDTO.setUrl(" ");
        //线程池异步保存日志
        UserLogThreadPool.execute(() -> userLogService.saveUserLog(userLogDTO));
        return ResponseBean.successResponse(null, "调用记录日志成功");
    }
}
