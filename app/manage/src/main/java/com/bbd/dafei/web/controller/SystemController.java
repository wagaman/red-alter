package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.CommonService;
import com.bbd.dafei.biz.shared.RaBlackListService;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Ian.Su
 * @version $Id: SystemController.java, v 0.1 2017/4/25 10:45 Ian.Su Exp $
 */
@Api("系统控制")
@RestController("系统控制")
@RequestMapping("/system")
public class SystemController extends BaseController {

    @Autowired
    private CommonService comSer;


    @Autowired
    private RaBlackListService blackListService;


    @ApiOperation(value = "根据路径下载文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "path", value = "路径", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/download.do", method = RequestMethod.GET)
    public void download(String path, HttpServletResponse response) {

        try {
            File file = new File(path);
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setHeader("content-disposition", "attachment;filename=" + file.getName());
            OutputStream out = response.getOutputStream();
            FileUtils.copyFile(file, response.getOutputStream());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("下载文件失败", e);
        }


    }


    @ApiOperation(value = "简单测试脚本")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shell", value = "脚本", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/shell.do", method = RequestMethod.GET)
    public Object shell(String shell) throws Exception {
        String[] cmds = {"/bin/sh", "-c", shell};
        Process pro = Runtime.getRuntime().exec(cmds);
        pro.waitFor();
        InputStream in = pro.getInputStream();
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = read.readLine()) != null) {
            out.append(line).append("<br/>\n");
        }
        return out.toString();
    }


    @ApiOperation(value = "简单查询语句")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sql", value = "sql语句", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/sql.do", method = RequestMethod.GET)
    public Object sql(String sql) throws Exception {

        return comSer.exesql(sql);

    }


    @ApiOperation(value = "初始化黑名单", notes = "每次更新数据后需执行此初始化")
    @RequestMapping(value = "/init/black.do", method = RequestMethod.GET)
    public ResponseBean<String> initBlack() throws Exception {

        blackListService.initBlack();

        return ResponseBean.successResponse("已初始化黑名单");

    }


}
