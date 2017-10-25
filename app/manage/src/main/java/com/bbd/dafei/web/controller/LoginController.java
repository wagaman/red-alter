package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.UserService;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.UserInfo;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by tuanhong on 2017/4/17.
 */
@Controller
@RequestMapping("/login")
@Api(value = "/login", tags = "用户登录")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userLogin.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "用户登录", notes = "根据输入用户名和密码进行登录，如：用户名：u1,密码：bbd123456")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ip", value = "用户IP", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "ipLocation", value = "IP归属地", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String")})
    public ResponseBean<UserPO> userLogin(@RequestParam String username,
                                          @RequestParam String password,
                                          String ip, String ipLocation,
                                          HttpServletRequest req) throws NoSuchAlgorithmException {

        //合法性检查--密码或者用户名为空表示没有登录
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            //提示错误信息
            return ResponseBean.errorResponse(203, "用户名或密码为空");
        }
        //取得User相关信息用于判断后台客户登录信息是否正确
        UserPO userPO = this.userService.findManageUserByName(username);

        //检验用户名 与 密码是否匹配
        if (userPO == null) {
            return ResponseBean.errorResponse(203, "用户名不存在");
        } else {
            //检查用户状态是否正确
            if (userPO.getUserStatus() == null || userPO.getUserStatus().equals("")) {
                return ResponseBean.errorResponse(203, "数据错误，用户状态空白");
            } else {
                if ("注销".equals(userPO.getUserStatus())) {
                    return ResponseBean.errorResponse(203, "该用户已被注销");
                } else if ("冻结".equals(userPO.getUserStatus())) {
                    return ResponseBean.errorResponse(203, "该用户已被冻结");
                }
            }

            //根据盐值进行加密
            String newPassword = this.userService.getPasswrodForMD5(password, userPO.getSalt());
            //匹配用户密码
            if (!userPO.getPassword().equals(newPassword)) {
                return ResponseBean.errorResponse(203, "密码错误");
            }
        }
        req.getSession().setAttribute(Constants.SESSION_USER, userPO);

        UserInfo info = new UserInfo();
        info.setIp(ip);
        info.setIpLocation(ipLocation);

        req.getSession().setAttribute(Constants.SESSION_INFO, info);

        return ResponseBean.successResponse(userPO);
    }

    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "用户退出", notes = "退出当前登录系统")
    public ResponseBean loginOut(HttpServletRequest req) {
        req.getSession().invalidate();
        return ResponseBean.successResponse("");
    }
}