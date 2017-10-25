package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.CommonService;
import com.bbd.dafei.biz.shared.RaReportDetailService;
import com.bbd.dafei.common.annotation.UserLog;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.DownloadAndUploadUtil;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;

/**
 * Created by tuanhong on 2017-04-23.
 */
@Controller
@RequestMapping(value = "/downloadReports")
@Api(value = "/downloadReports", tags = "下载报告，报告样例")
public class DownloadReportsController extends BaseController {

    @Autowired
    private RaReportDetailService raReportDetailService;

    @Autowired
    private CommonService commonService;

//    private static final String docs = SystemUtils.getJavaIoTmpDir().getParent() + "/fileUpload/";

    @RequestMapping(value = "/downloadResearchExample.do", method = RequestMethod.GET)
    @ApiOperation(value = "研报样例", notes = "下载研报样例")
    @UserLog
    public void downloadResearchExample(HttpServletRequest request, HttpServletResponse response) {
        DownloadAndUploadUtil.FilesDownload(request, response, "/files/download/研报样例.docx");
    }

    @RequestMapping(value = "/downloadResearchReport.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "下载研报", notes = "下载研报 如公司：启阳（成都）投资管理有限公司 申请日期：20170420")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "applyTime", value = "研报申请日期", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "reportId", value = "研报申请ID", required = true, paramType = "query", dataType = "int")
    })
    @UserLog
    public ResponseBean downloadResearchReport(String companyId, String applyTime, int reportId, HttpServletRequest request, HttpServletResponse response) {
        //根据用户ID 和公司名称以及申请时间 取得 上传的文件类型
        UserPO userPO = getSessionUser();
        String newApplyTime = applyTime.replace("-", "");
//        String fileType = this.raReportDetailService.findFileType(userPO.getId(), company, newApplyTime);
//        if (null == fileType || fileType.equals("")) {
//            return ResponseBean.errorResponse("未找到研文件类型");
//        } else {
//        }

        //取得下载的url
        String reportUrl = this.raReportDetailService.findReportUrl(reportId);
//        String filePath = "/files/upload/" + company + "_" + newApplyTime + "." + fileType;
        String filePath = commonService.getFileUploadPath() + reportUrl;


        //下载完成后更新 研报下载时间
        String newStatus = Constants.REPORT_STATUS_DOWNLOAD;
        Date gmtUpdate = new Date();
        this.raReportDetailService.updateDownTime(newStatus, gmtUpdate, userPO.getId(), companyId, newApplyTime);

        DownloadAndUploadUtil.FilesDownload(request, response, filePath);

        return ResponseBean.successResponse("下载成功");
    }

    @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "上传研报", notes = "上传研报")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyName", value = "公司名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "inputFile", value = "上传文件", required = true, paramType = "query", dataType = "MultipartFile")})
    public ResponseBean upload(@RequestParam(value = "companyName") String companyName, @RequestParam(value = "file") MultipartFile file, HttpServletRequest request) throws Exception {

        //根据用户ID 和公司名称取得 申请时间
//        String company = new String(companyName.getBytes("ISO-8859-1"),"UTF-8");
        UserPO userPO = getSessionUser();
        String reportStatus = Constants.REPORT_STATUS_MAKING;
        String applyTime = raReportDetailService.findApplyTimeByUserIdAndCompany(userPO.getId(), companyName, reportStatus);


        if (null == applyTime || applyTime.equals("")) {
            return ResponseBean.errorResponse("未查询到该企业有未上传的研报信息");
        } else {
            String fileName = file.getOriginalFilename();
            String saveName = companyName + "_" + applyTime + fileName.substring(fileName.lastIndexOf("."));
            //上传路径
//            String uploadPath = "/files/upload/"+saveName ;

            File filePath = new File(commonService.getFileUploadPath());
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            String uploadPath = commonService.getFileUploadPath() + saveName;
            String uploadInfo = DownloadAndUploadUtil.FilesUpload(request, file, uploadPath);
//
            if (null != uploadInfo && uploadInfo.equals("success")) {

                //上传成功后，修改研报状态为未下载
                String newStatus = Constants.REPORT_STATUS_UN_DOWNLOAD;
                Date gmtUpdate = new Date();
                String fileType = fileName.substring((fileName.lastIndexOf(".") + 1));
                int userId = userPO.getId();
                String oldStatus = Constants.REPORT_STATUS_MAKING;

                this.raReportDetailService.updateReportStatusByUserIdAndCompany(newStatus, gmtUpdate, fileType, userId, companyName, oldStatus);
            } else {
                return ResponseBean.errorResponse("上传失败，请稍后再试");
            }
        }
        return ResponseBean.successResponse("上传成功");
    }

    @RequestMapping(value = "/checkFileType.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "下载时判断用户是否已上传文件", notes = "下载时判断用户是否已上传文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reportId", value = "公司ID", required = true, paramType = "query", dataType = "int")})
    public ResponseBean checkFileType(int reportId) {
        String fileType = this.raReportDetailService.findFileType(reportId);
        if (null == fileType || fileType.equals("")) {
            return ResponseBean.errorResponse("未找到研报文件类型，请确认是否已经上传文件");
        } else {
            return ResponseBean.successResponse("");
        }
    }
}
