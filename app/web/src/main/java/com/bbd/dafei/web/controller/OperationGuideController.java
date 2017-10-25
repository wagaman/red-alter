package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.CommonService;
import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.DownloadAndUploadUtil;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by wish on 2017/6/13.
 */
@RestController
@RequestMapping("/operationGuide")
@Api(value = "/operationGuide", tags = "操作手册")
public class OperationGuideController {

    @Autowired
    private CommonService commonService;

    @ApiOperation(value = "下载操作手册", notes = "下载操作手册")
    @RequestMapping(value = "/download.do", method = RequestMethod.GET)
    public ResponseBean<Boolean> download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String filePath = commonService.getFileUploadPath() + Constants.OPERATION_GUIDE_FILE_NAME;
        filePath = request.getServletContext().getRealPath(filePath);
        if (!new File(filePath).exists()) {
            throw new CommonException("下载失败，文件不存在");
        }
        DownloadAndUploadUtil.FilesDownload(request, response, filePath);
        return ResponseBean.successResponse(null, "下载操作手册成功");
    }
}