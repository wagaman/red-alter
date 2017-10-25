package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.PdfService;
import com.bbd.dafei.biz.shared.UserService;
import com.bbd.dafei.common.annotation.UserLog;
import com.bbd.dafei.common.dal.po.UserPO;
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
import javax.servlet.http.HttpServletResponse;


/**
 * Created by tuanhong on 2017-04-24.
 */
@Controller
@RequestMapping("/pdf")

@Api(value = "/pdf", tags = "下载简报")
public class PdfController extends BaseController {
    @Autowired
    private PdfService pdfService;

    @Autowired
    private UserService userService;

    /**
     * 导出pdf 报告
     *
     * @param companyId 公司名称
     */
    @RequestMapping(value = "/exportPdf.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "下载简报", notes = "根据公司名称产生简报PDF")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "企业Id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "companyName", value = "企业名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "userName", value = "用户账号,用于外部系统调用时传递用户", paramType = "query", dataType = "String")})
    @UserLog
    public void exportPdf(String companyId, String companyName, String userName, HttpServletResponse response, HttpServletRequest request) throws Exception {
        UserPO userPO = getSessionUser();
        //session 中不存在用户，则通过参数传递的账号查询用户
        if (userPO == null) {
            userPO = userService.findByName(userName);
        }
        pdfService.makesPdf(request, response, companyId, companyName, userPO);
    }
}
