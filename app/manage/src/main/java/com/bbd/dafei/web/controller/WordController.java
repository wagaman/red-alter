package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.WordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuanhong on 2017-05-23.
 */
@Controller
@RequestMapping("/word")
@Api(value = "/word", tags = "下载word")
public class WordController extends BaseController {

    private final String downloading = "downloading";

    @Autowired
    private WordService wordService;

    /**
     * 导出word 报告
     *
     * @param companyId   公司ID
     * @param companyName 公司名称
     */
    @RequestMapping(value = "/exportWord.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "下载简报", notes = "根据公司名称产生简报WORD")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "企业id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "companyName", value = "企业名称", required = true, paramType = "query", dataType = "String")})
    public Object exportWord(String companyId, String companyName, HttpServletResponse response, HttpServletRequest request) throws Exception {
        try {

            request.getSession().setAttribute(downloading, true);

            final Map<String, Object> map = new HashMap<>();

            String fileName = companyName + ".doc";
            response.reset();
            response.addHeader("Content-disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/octet-stream");
            ServletOutputStream out = response.getOutputStream();
            wordService.createWord(request, out, companyName, companyId, getPath("/word/img/index.png"),
                    getPath("/word/img/buttom.png"),
                    getPath("/word/img/report.png"),
                    getPath("/word/img/backCover.png"));

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("下载简报失败", e);
        } finally {
            request.getSession().removeAttribute(downloading);
        }
        return null;
    }

    private String getPath(String fileNameAndPath) {
        return WordController.class.getClassLoader().getResource(fileNameAndPath).getPath();
    }
}
