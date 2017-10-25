package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.UserLogService;
import com.bbd.dafei.common.modal.dto.UserLogDTO;
import com.bbd.dafei.common.util.CommonUtil;
import com.bbd.dafei.common.util.ExportExcel;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by wish on 2017/5/24.
 */
@Controller
@RequestMapping("/userLog")
@Api(value = "/userLog", tags = "用户日志")
public class UserLogController extends BaseController {

    @Autowired
    private UserLogService userLogService;

    //用户日志导出EXCEL表头
    private static final String userLogExport = "[" +
            "{\"key\":\"userName\",\"value\":\"用户名\"}" +
            "{\"key\":\"gmtCreate\",\"value\":\"操作日期\"}" +
            "{\"key\":\"page\",\"value\":\"页面类型\"}" +
            "{\"key\":\"operation\",\"value\":\"使用日志\"}" +
            "{\"key\":\"ip\",\"value\":\"IP地址\"}" +
            "{\"key\":\"ipLocation\",\"value\":\"IP归属地\"}" +
            "{\"key\":\"detail\",\"value\":\"详情记录\"}" +

            "]";

    @RequestMapping(value = "/userLogList.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询用户操作日志", notes = "分页条件查询用户操作日志")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "startDate", value = "开始时间（yyyy-MM-dd）", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endDate", value = "结束时间（yyyy-MM-dd）", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageType", value = "页面类型", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<UserLogDTO>> findUserLogList(String userName, String startDate, String endDate, String pageType, @RequestParam(defaultValue = "1") Integer page,
                                                              @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {

        PageInfo<UserLogDTO> pageInfo = userLogService.findUserLogPage(userName, startDate, endDate, pageType, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/exportUserLog.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "导出用户操作日志", notes = "导出用户操作日志,如果传递logIds，则导出id对应的数据，否则根据筛选条件导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "logIds", value = "日志id", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "userName", value = "用户名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "startDate", value = "开始时间（yyyy-MM-dd）", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endDate", value = "结束时间（yyyy-MM-dd）", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageType", value = "页面类型", paramType = "query", dataType = "String")
    })
    public Object exportUserLog(@RequestParam(value = "logIds", required = false) List<Integer> logIds, String userName,
                                String startDate, String endDate, String pageType, HttpServletResponse response, HttpServletRequest req) throws Exception {
        List<UserLogDTO> userLogDTOList;
        //如果传递logIds，则导出id对应的数据，否则根据筛选条件导出
        if (CollectionUtils.isNotEmpty(logIds)) {
            userLogDTOList = userLogService.findLogsByIds(logIds);
        } else {
            //page 传0查询全部
            PageInfo<UserLogDTO> pageInfo = userLogService.findUserLogPage(userName, startDate, endDate, pageType, 0, 0);
            userLogDTOList = pageInfo.getItems();
        }
        HSSFWorkbook hssfWorkbook = ExportExcel.exportExcel("用户操作日志", userLogExport, userLogDTOList, "yyyy-MM-dd HH:mm:ss");
        response.setCharacterEncoding("utf-8");
        // 清空response
        response.reset();
        response.addHeader("Content-Disposition", "attachment;filename=" + CommonUtil.getFileName("用户操作日志.xls", req));
        response.setContentType("application/octet-stream");
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        hssfWorkbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

        return ResponseBean.successResponse("");
    }

    @RequestMapping(value = "/findAllPageType.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询所有页面类型", notes = "查询所有页面类型")
    public ResponseBean<List<String>> findAllPageType() throws Exception {
        List<String> pageTypes = userLogService.findAllPageType();
        return ResponseBean.successResponse(pageTypes);
    }


}
