package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.CommonService;
import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.util.DownloadAndUploadUtil;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 公共controller
 * Created by wish on 2017/5/26.
 */
@Controller
@RequestMapping("/common")
@Api(value = "/common", tags = "公共")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/findProvince.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "省份列表", notes = "查询省份列表")
    public ResponseBean<List<String>> findProvince() throws Exception {
        List<String> provinces = commonService.getProvinces();
        return ResponseBean.successResponse(provinces);
    }

    @ApiOperation(value = "下载临时文件", notes = "下载临时文件，下载后删除")
    @RequestMapping(value = "/downloadTempFile.do", method = RequestMethod.GET)
    public ResponseBean downloadTempFile(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException {
        String filePath = commonService.getTempPath() + fileName;
        if (!new File(filePath).exists()) {
            throw new CommonException("下载失败，文件不存在");
        }
        DownloadAndUploadUtil.FilesDownload(request, response, filePath);
        return ResponseBean.successResponse(null, "下载成功");
    }
}
