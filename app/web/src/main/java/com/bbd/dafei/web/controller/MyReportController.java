package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.MyReportService;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.vo.MyReportListVO;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.PageInfoIgnore;
import com.bbd.dafei.common.util.Paging;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuanhong on 2017-04-24.
 */
@Controller
@RequestMapping(value = "/myReport")
@Api(value = "/myReport", tags = "个人中心-我的报告")
public class MyReportController extends BaseController {

    @Autowired
    private MyReportService myReportService;

    @RequestMapping(value = "getReportList.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "个人中心--我的报告", notes = "查询我的报告列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", paramType = "query", value = "每页数据量", defaultValue = "10", dataType = "Integer"),
            @ApiImplicitParam(name = "page", paramType = "query", value = "记录起始", defaultValue = "0", dataType = "Integer")})
    public ResponseBean<Paging<MyReportListVO>> getReportList(@RequestParam(defaultValue = "10") Integer pageSize,
                                                              @RequestParam(defaultValue = "1")  Integer page) throws Exception {

        UserPO userPO = getSessionUser();
        Object data = myReportService.query(userPO.getId(), userPO.getUsername(),(page-1)*pageSize, pageSize);

        return ResponseBean.successResponse(data);

    }

    @RequestMapping(value = "getUnDowanloadTotalNum.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "个人中心--查询用户所有未下载的研报的总数量", notes = "查询用户所有未下载的研报的总数量")
    public ResponseBean<Integer> getUnDowanloadTotalNum() {
        UserPO userPO = getSessionUser();
        String reportStatus = Constants.REPORT_STATUS_UN_DOWNLOAD;
        int totalNumber = this.myReportService.queryCount(userPO.getId(), reportStatus);
        return ResponseBean.successResponse(totalNumber);
    }


    @RequestMapping(value = "getApplyTime.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询研报申请时间", notes = "查询研报申请时间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "企业id", required = true, paramType = "query", dataType = "String")})
    public ResponseBean getApplyTime(@ApiParam String companyId) throws Exception {
       Map<String,String> data = new HashMap<String,String>();
        UserPO userPO = getSessionUser();
        //先取 研报状态为生成中的资料
       String reportStatus = Constants.REPORT_STATUS_MAKING;
        String applyTime = this.myReportService.getApplyTime(userPO.getId(), companyId, reportStatus);
       if(null == applyTime || applyTime.equals("")){
          //取最近一次申请 研报的 信息
          String maxApplyTime = this.myReportService.getMaxApplyTime(userPO.getId(), companyId, reportStatus);
          data.put("reportStatus","--");
          data.put("applyTime",maxApplyTime);
       }else{
          data.put("reportStatus",Constants.REPORT_STATUS_MAKING);
          data.put("applyTime",applyTime);
       }
        return ResponseBean.successResponse(data);
    }

}
