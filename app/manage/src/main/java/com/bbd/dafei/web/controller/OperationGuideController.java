package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.CommonService;
import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @ApiOperation(value = "上传操作手册", notes = "上传操作手册")
    @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    public ResponseBean<Boolean> upload(MultipartFile file) throws Exception {
        if (!file.getOriginalFilename().endsWith(".pdf")) {
            throw new CommonException("无效的pdf文件，请选择pdf格式的文件");
        }
        String filename = Constants.OPERATION_GUIDE_FILE_NAME;
        String path = commonService.getFileUploadPath() + "/" + filename;
        File operationGuide = new File(path);
        file.transferTo(operationGuide);
        return ResponseBean.successResponse(null, "上传操作手册成功");
    }
}
