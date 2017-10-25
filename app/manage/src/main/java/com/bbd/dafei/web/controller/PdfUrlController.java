package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.PdfService;
import com.bbd.dafei.common.dal.po.UserPO;
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

/**
 * Created by tuanhong on 2017-06-05.
 */
@Controller
@RequestMapping("/pdf")
@Api("pdf路径")
public class PdfUrlController extends BaseController {

    @Autowired
    private PdfService pdfService;

    @RequestMapping(value = "/getPdfUrl.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取PDF路径", notes = "取得PDF调用路径")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "企业id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "companyName", value = "企业名", required = true, paramType = "query", dataType = "String")})
    public ResponseBean<String> exportWord(String companyId, String companyName) throws Exception {
        UserPO userPO = getSessionUser();
        return ResponseBean.successResponse(pdfService.getPdfUrl(companyId, companyName, userPO));
    }
}
