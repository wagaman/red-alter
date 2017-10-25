/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.TestService;
import com.bbd.dafei.common.exception.AccessApiException;
import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.util.ResponseBean;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 *
 * @author byron
 * @version $Id: TestController.java, v 0.1 Oct 26, 2016 4:18:20 PM byron Exp $
 */
@Controller
@RequestMapping("/test")
@Api(value = "/test", tags = "测试")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;


    @RequestMapping("/index")
    @ApiIgnore
    @ResponseBody
    public Object showIndex() {

        Gson gson = new Gson();



        Map<String ,Object> map = new HashMap<>();
        map.put("a","a");
        map.put("c","12");

        String json = gson.toJson(map);
        System.out.println(json);
        return "{\"a\":\"a\",\"c\":\"1dddd2\"}";
    }

    @RequestMapping(value = "/500.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "500异常测试", notes = "异常测试")
    public ResponseBean<Integer> exception500() throws Exception {
        if (true) {
            throw new CommonException("有异常");
        }
        return null;
    }


    @RequestMapping(value = "/400.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "400异常测试", notes = "异常测试")
    public ResponseBean<Integer> exception400(@RequestParam String a, @RequestParam Integer b) throws Exception {
        if (true) {
            throw new CommonException("有异常");
        }
        return null;
    }


    @RequestMapping(value = "/apiExecption.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "api异常异常测试", notes = "异常测试")
    public ResponseBean<Integer> apiExecption(@RequestParam String a, @RequestParam Integer b) throws Exception {
        if (true) {
            throw new AccessApiException("api异常");
        }
        return null;
    }

    @RequestMapping(value = "/test.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "测试", notes = "测试")
    public ResponseBean<Integer> test() throws Exception {
        testService.say();
        return ResponseBean.successResponse(new Integer(0));
    }

}