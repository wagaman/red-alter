package com.bbd.dafei.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.commons.lang.monitor.entity.APPBaseInfo;
import com.bbd.commons.lang.monitor.entity.APPModuleStatus;
import com.bbd.commons.lang.monitor.entity.AppBaseStatus;
import com.bbd.commons.lang.monitor.entity.AppStatus;
import com.bbd.commons.lang.monitor.inf.IStandardMonitor;
import com.bbd.commons.lang.rt.JsonRet;
import com.bbd.dafei.biz.shared.IndexService;
import com.components.service.ApiExecuteEngineService;
import com.google.gson.Gson;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InterfaceStateImpl implements IStandardMonitor {

    public final static APPBaseInfo appBaseInfo;

    @Qualifier("testApiExecEngine")
    @Autowired
    private ApiExecuteEngineService apiExecuteEngineService;

    @Autowired
    private IndexService indexService;
    static {
        appBaseInfo = new APPBaseInfo();
        // 每个应用生成一个，不再发生变化
        appBaseInfo.setAppGuid("ra-two-c5b6-44f2-9608-84c74d7fe0ba");
        // 应用名称
        appBaseInfo.setAppName("ra-two");
        // 系统owner
        appBaseInfo.setAppOwner("suyin");
        // 应用版本号
        appBaseInfo.setAppVersion("4.0");
    }

    public static void main(String[] args) {

        IStandardMonitor iStandardMonitor = new InterfaceStateImpl();
        System.out.println((iStandardMonitor.getStandardAppStatus()));
    }


    @Override
    public String getStandardAppStatus() {

        AppStatus appStatus = new AppStatus();
        appStatus.setAppBaseStatus(new AppBaseStatus());
        appStatus.setAppBaseInfo(appBaseInfo);

        List<APPModuleStatus> modules = new ArrayList<>();
        modules.add(getRelatedParty());
        modules.add(getQueryMessage());
        modules.add(getDataApi());

        appStatus.setModuleStatus(modules);
        return new Gson().toJson(appStatus);

    }



    /**
     * transfer关联方
     * @return
     */
    private APPModuleStatus getRelatedParty(){

        APPModuleStatus transferModule = new APPModuleStatus();
        transferModule.setModuleName("transfer项目关联方调用模块");
        try {
            String apiId = "transfer_relation";
            Object o = apiExecuteEngineService.execute(apiId,null);
            transferModule.setStatusMessage("transfer关联方正常");
            transferModule.setStatusLevel(0);
            transferModule.setPrivateMessage(new Gson().toJson(o));
        }catch (Exception e) {
            transferModule.setStatusMessage("transfer关联方异常");
            transferModule.setStatusLevel(2);
            transferModule.setPrivateMessage(e.getMessage());
            e.printStackTrace();
        }

        return transferModule;
    }






    /**
     * mysql查询模块
     * @return
     */
    private APPModuleStatus getQueryMessage(){

        APPModuleStatus queryMessage = new APPModuleStatus();
        queryMessage.setModuleName("Mysql查询模块");
        try {
            String userProvince = "四川省";
            String industry = "新兴金融";
            Object o = indexService.mapProvince(userProvince,industry);
            queryMessage.setPrivateMessage("Mysql查询正常");
            queryMessage.setStatusLevel(0);
            queryMessage.setPrivateMessage(new Gson().toJson(o));
        }catch (Exception e) {
            queryMessage.setPrivateMessage("Mysql查询出错");
            queryMessage.setStatusLevel(2);
            queryMessage.setPrivateMessage(e.getMessage());
            e.printStackTrace();
        }

        return queryMessage;
    }




    /**
     * dataapi接口
     * @return
     */
    private APPModuleStatus getDataApi(){

        APPModuleStatus queryDataApi =  new APPModuleStatus();
        queryDataApi.setModuleName("查询dataApi基本信息接口模块");
        try {
            String apiId = "api_bbd_jbxx_batch";
            Object o = apiExecuteEngineService.execute(apiId,null);
            queryDataApi.setStatusMessage("dataApi基本信息接口正常");
            queryDataApi.setStatusLevel(0);
            queryDataApi.setPrivateMessage(new Gson().toJson(o));
        }catch (Exception e) {
            queryDataApi.setStatusMessage("dataApi基本信息接口接口出错");
            queryDataApi.setStatusLevel(2);
            queryDataApi.setPrivateMessage(e.getMessage());
        }

        return queryDataApi;
    }
}
