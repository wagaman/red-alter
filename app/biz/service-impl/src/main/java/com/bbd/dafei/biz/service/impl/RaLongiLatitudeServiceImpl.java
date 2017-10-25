package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.RaLongiLatitudeService;
import com.bbd.dafei.common.dal.mapper.RaLongLatitudeMapper;
import com.bbd.dafei.common.dal.po.RaLongiLatitudePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ian.Su
 * @version $Id: RaLongiLatitudeServiceImpl.java, v 0.1 2017/4/25 16:44 Ian.Su Exp $
 */
@Service
public class RaLongiLatitudeServiceImpl implements RaLongiLatitudeService {

    @Autowired
    private RaLongLatitudeMapper longiLatiMapper;

    @Override
    public List<RaLongiLatitudePO> query(String province, String city, String area) {
        return longiLatiMapper.query(province,city,area);
    }
}
