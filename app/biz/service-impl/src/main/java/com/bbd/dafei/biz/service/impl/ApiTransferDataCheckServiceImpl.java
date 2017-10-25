package com.bbd.dafei.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.components.exception.ApiException;
import com.components.service.ApiAddressParamAssemblyInterface;
import com.components.service.ApiDataCheckService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2017-07-27.
 */
@Service(value="apiTransferDataCheckService")
public class ApiTransferDataCheckServiceImpl implements ApiDataCheckService,ApiAddressParamAssemblyInterface {

    @Override
    public boolean checkData(String address, Map<String, Object> params, Object value) throws Exception {

        JSONObject object = (JSONObject)JSONObject.parse(value.toString());

        if (object.getBoolean("success")) {

            return  true;
        }

        String msg = assembly(address, params, value);

        throw new ApiException(msg);

    }
}
