package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.MultiFeedbackService;
import com.bbd.dafei.common.modal.vo.FeedbackVO;
import com.bbd.dafei.common.util.CommonUtil;
import com.bbd.dafei.common.util.ExportExcel;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/**
 * 用户反馈相关接口
 *
 * @author Ian.Su
 * @version $Id: FeedbackController.java, v 0.1 2017/5/27 9:24 Ian.Su Exp $
 */
@RestController
@RequestMapping("/feedback")
@Api(value = "/feedback", tags = "反馈信息")
public class FeedbackController extends BaseController {


    @Autowired
    private MultiFeedbackService feedbackService;


    //关联方导出EXCEL表头
    private static final String feedBackExport = "[" +
            "{\"key\":\"company\",\"value\":\"企业名\"}" +
            "{\"key\":\"type\",\"value\":\"类别\"}" +
            "{\"key\":\"gmtCreate\",\"value\":\"加入/信息反馈日期\"}" +
            "{\"key\":\"joinContent\",\"value\":\"加入原因/填入内容\"}" +
            "{\"key\":\"cancelDate\",\"value\":\"取消日期\"}" +
            "{\"key\":\"cancelReason\",\"value\":\"取消原因\"}" +
            "{\"key\":\"user\",\"value\":\"操作用户\"}" +
            "]";


    @RequestMapping(value = "/query.do", method = RequestMethod.GET)
    @ApiOperation(value = "反馈查询", notes = "分页查询反馈信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "type", value = "类别(关注,备注,企业信息更新,平台信息反馈)", paramType = "query", dataType = "String", defaultValue = "黑名单"),
            @ApiImplicitParam(name = "startDate", value = "查询起始日期(yyyy-MM-dd)", paramType = "query", dataType = "String", example = "2017-12-11"),
            @ApiImplicitParam(name = "endDate", value = "查询结束日期(yyyy-MM-dd)", paramType = "query", dataType = "String", example = "2017-12-11"),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", defaultValue = "10", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<FeedbackVO>> query(String user,
                                                    String type,
                                                    String startDate,
                                                    String endDate,
                                                    int page,
                                                    int pageSize) {


        PageInfo<FeedbackVO> p = feedbackService.query(user, type, startDate, endDate, page, pageSize);

        return ResponseBean.successResponse(p);

    }

    @RequestMapping(value = "/export.do", method = RequestMethod.GET)
    @ApiOperation(value = "导出反馈信息", notes = "导出反馈信息志")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "type", value = "类别(黑名单,关注,备注,企业信息更新,平台信息反馈)", paramType = "query", dataType = "String", defaultValue = "黑名单"),
            @ApiImplicitParam(name = "startDate", value = "查询起始日期(yyyy-MM-dd)", paramType = "query", dataType = "String", example = "2017-12-11"),
            @ApiImplicitParam(name = "endDate", value = "查询结束日期(yyyy-MM-dd)", paramType = "query", dataType = "String", example = "2017-12-11")
    })
    public Object export(String user,
                         String type,
                         String startDate,
                         String endDate,
                         HttpServletRequest req,
                         HttpServletResponse response) throws Exception {
        //page 传0查询全部
        PageInfo<FeedbackVO> pageInfo = feedbackService.query(user, type, startDate, endDate, 0, 0);
        HSSFWorkbook hssfWorkbook = ExportExcel.exportExcel("反馈信息", feedBackExport, pageInfo.getItems(), "yyyy-MM-dd HH:mm:ss");
        response.setCharacterEncoding("utf-8");
        // 清空response
        response.reset();
        response.addHeader("Content-Disposition", "attachment;filename=" + CommonUtil.getFileName("反馈信息.xls", req));
        response.setContentType("application/octet-stream");
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        hssfWorkbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

        return ResponseBean.successResponse("");
    }


}
