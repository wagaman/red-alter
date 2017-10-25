package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.UserService;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.UserDTO;
import com.bbd.dafei.common.util.PageInfo;
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

import java.util.List;

/**
 * 用户相关Controller
 * Created by wish on 2017/5/25.
 */
@Controller
@RequestMapping("/user")
@Api(value = "/user", tags = "用户")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveFrontUser.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "保存前台用户", notes = "保存前台用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "province", value = "用户权限（省）", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "researchReportRemainTimes", value = "剩余研报次数", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "validDate", value = "账户有效期（yyyy-MM-dd）", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "email", value = "电子邮箱", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "remark", value = "备注", paramType = "query", dataType = "String")
    })
    public ResponseBean addFrontUser(UserDTO userDTO) throws Exception {
        UserPO userPO = getSessionUser();
        userDTO.setCreateBy(userPO.getUsername());
        userDTO.setUpdateBy(userPO.getUsername());
        userService.addFrontUser(userDTO);
        return ResponseBean.successResponse(null, "添加成功");
    }

    @RequestMapping(value = "/updateFrontUser.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "修改前台用户", notes = "修改前台用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "province", value = "用户权限（省）", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "researchReportRemainTimes", value = "剩余研报次数", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "validDate", value = "账户有效期（yyyy-MM-dd）", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "email", value = "电子邮箱", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "remark", value = "备注", paramType = "query", dataType = "String")
    })
    public ResponseBean updateFrontUser(UserDTO userDTO) throws Exception {
        UserPO userPO = getSessionUser();
        userDTO.setUpdateBy(userPO.getUsername());
        userService.updateFrontUser(userDTO);
        return ResponseBean.successResponse(null, "修改成功");
    }

    @RequestMapping(value = "/deleteUserByIds.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "删除用户", notes = "删除注销用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userIds", value = "用户id", paramType = "query", required = true, dataType = "Integer"),
    })
    public ResponseBean deleteUserByIds(@RequestParam("userIds") List<Integer> userIds) throws Exception {
        UserPO userPO = getSessionUser();
        userService.updateLogoutBatchByIds(userIds, userPO.getUsername());
        return ResponseBean.successResponse(null, "删除用户成功");
    }

    @RequestMapping(value = "/findFrontUserInfoListPage.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询前台用户列表", notes = "分页条件查询前台用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "province", value = "省份", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<UserDTO>> findFrontUserInfoListPage(String userName, String province, @RequestParam(defaultValue = "1") Integer page,
                                                                @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {

        PageInfo<UserDTO> pageInfo = userService.findFrontUserInfoListPage(userName, province, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }


    @RequestMapping(value = "/findUserInfoById.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询用户信息", notes = "根据用户id查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户名", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<UserDTO> findUserInfoById(@RequestParam Integer userId) throws Exception {

        UserDTO userDTO = userService.findUserInfoById(userId);
        return ResponseBean.successResponse(userDTO);
    }

    @RequestMapping(value = "/findUserById.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询用户信息", notes = "根据用户id查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户名", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<UserPO> findUserById(@RequestParam Integer userId) throws Exception {
        UserPO userPO = userService.findUserById(userId);
        return ResponseBean.successResponse(userPO);
    }

    @RequestMapping(value = "/findManageUserInfoListPage.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询后台用户列表", notes = "分页条件查询后台用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<UserPO>> findManageUserInfoListPage(String userName, String province, @RequestParam(defaultValue = "1") Integer page,
                                                                     @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {

        PageInfo<UserPO> pageInfo = userService.findManageUserInfoListPage(userName, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/saveManageUser.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "保存后台用户", notes = "保存后台用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "remark", value = "备注", paramType = "query", dataType = "String")
    })
    public ResponseBean addManageUser(UserDTO userDTO) throws Exception {
        UserPO userPO = getSessionUser();
        userDTO.setCreateBy(userPO.getUsername());
        userDTO.setUpdateBy(userPO.getUsername());
        userService.addManageUser(userDTO);
        return ResponseBean.successResponse(null, "添加成功");
    }

    @RequestMapping(value = "/updateManageUser.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "修改后台用户", notes = "修改前台用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "remark", value = "备注", paramType = "query", dataType = "String")
    })
    public ResponseBean updateManageUser(UserDTO userDTO) throws Exception {
        UserPO userPO = getSessionUser();
        userDTO.setUpdateBy(userPO.getUsername());
        userService.updateManageUser(userDTO);
        return ResponseBean.successResponse(null, "修改成功");
    }


}
