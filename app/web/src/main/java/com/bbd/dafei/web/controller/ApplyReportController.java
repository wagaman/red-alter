package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.RaReportDetailService;
import com.bbd.dafei.biz.shared.RaResearchReportService;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by tuanhong on 2017-04-21.
 */
@Controller
@RequestMapping("/applyReport")
@Api(value = "/applyReport", tags = "申请生成研报")
public class ApplyReportController extends BaseController {
    @Autowired
    private RaReportDetailService reportDetailSer;

    @Autowired
    private RaResearchReportService researchReportSer;

    @RequestMapping(value = "/getResearchInfo.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "研报下载信息", notes = "获取研报下载信息")
    public ResponseBean getResearchInfo() throws Exception {
        UserPO userPO = getSessionUser();
        return ResponseBean.successResponse(this.researchReportSer.findByUserId(userPO.getId()));
    }

    @RequestMapping(value = "/makeResearch.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "生成研报", notes = "根据客户申请产生研报申请信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "企业ID", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "company", value = "企业名称", required = true, paramType = "query", dataType = "String")})
    public ResponseBean makeResearch(@ApiParam String companyId, @ApiParam String company) throws Exception {
        UserPO userPO = getSessionUser();

        Map<String, String> message = this.reportDetailSer.applyResearch(userPO.getId(), userPO.getUsername(), companyId, company);

        if (message.size() != 0) {
            return ResponseBean.errorResponse(500, message.get("msg"));
        } else {
            return ResponseBean.successResponse("");
        }
    }
}
