package com.bbd.dafei.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.components.service.ApiDataProcessingService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 处理数据平台数据返回
 */
@Service("apiDataformDataProcessingService")
public class ApiDataformDataProcessingServiceImpl implements ApiDataProcessingService {
    @Override
    public Object processing(String address, Map<String, Object> externalParam, Map<String, Object> combineParams, Object rawData) {
        Map<String , Object> map =  (Map<String,Object>)JSONObject.parse((String)rawData);
            return map.get("data");
    }
}
