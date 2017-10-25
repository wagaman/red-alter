package com.bbd.dafei.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.components.service.ApiDataProcessingService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 处理数据平台数据返回
 * Created by wish on 2017/8/3.
 */
@Service("dataPlatformDataProcessingService")
public class DataPlatformDataProcessingServiceImpl implements ApiDataProcessingService {
    public DataPlatformDataProcessingServiceImpl() {
    }

    public Object processing(String address, Map<String, Object> externalParam, Map<String, Object> combineParams, Object rawData) {
        Map<String,Object> map =  (Map<String,Object>)JSONObject.parse((String)rawData);
        return map.get("results");
    }
}
