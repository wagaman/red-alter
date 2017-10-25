package com.bbd.dafei.web.controller;
import com.alibaba.dubbo.common.Constants;
import com.bbd.dafei.biz.service.impl.InterfaceStateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InterfaceStateController {

    @Autowired
    private  InterfaceStateImpl interfaceState;

    @RequestMapping(value = "/standardmonitor" , produces = "text/json;charset=UTF-8")
    public Object getInterfaceState( String appGuid ){

        if(!InterfaceStateImpl.appBaseInfo.getAppGuid().equals(appGuid)){
            return "appGuid值传递错误，正确值请联系红警4期团队";
        }



        return interfaceState.getStandardAppStatus();
    }
}
