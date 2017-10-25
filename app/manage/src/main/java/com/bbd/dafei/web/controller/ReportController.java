package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.CommonService;
import com.bbd.dafei.biz.shared.RaReportDetailService;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.RaReportDetailDTO;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.PageInfoIgnore;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;

/**
 * 研报
 * @author Ian.Su
 * @version $Id: ReportController.java, v 0.1 2017/5/24 14:51 Ian.Su Exp $
 */
@RestController
@RequestMapping("/report")
@Api(value = "/report", tags = "研报管理")
public class ReportController extends BaseController {


    @Autowired
    private RaReportDetailService reportDetailService;

    @Autowired
    private CommonService commonService;



    @RequestMapping(value = "/query/upload.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "研报查询", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "query", dataType = "String")})
    public ResponseBean<PageInfo<RaReportDetailDTO>> queryUpload(PageInfoIgnore page){

       Object pageInfo = reportDetailService.query(page);

       return ResponseBean.successResponse(pageInfo);

    }


    @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "上传研报", notes = "上传研报")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "研报ID", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "companyName", value = "公司名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "file", value = "上传文件", required = true, paramType = "query", dataType = "file")})
    public ResponseBean upload(@RequestParam Integer id,
                               @RequestParam(value = "companyName")String companyName,
                               @RequestParam(value = "file") MultipartFile file, HttpServletRequest request) throws Exception {


        String filepath = commonService.getFileUploadPath();
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String reportUrl = companyName + DateFormatUtils.format(new Date(),"yyyyMMddHHmmss")+suffix;
        filepath =filepath + reportUrl;
        file.transferTo(new File(filepath));

        //上传成功后，修改研报状态为未下载
        String newStatus = Constants.REPORT_STATUS_UN_DOWNLOAD;
        String fileType = fileName.substring((fileName.lastIndexOf(".") + 1));
        int userId = getSessionUser().getId();

        reportDetailService.updateReportStatusById(id,reportUrl,newStatus, fileType, userId);


        return ResponseBean.successResponse("上传成功");
    }









}
