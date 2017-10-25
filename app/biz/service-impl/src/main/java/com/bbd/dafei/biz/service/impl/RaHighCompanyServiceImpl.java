package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.RaHighCompanyService;
import com.bbd.dafei.common.dal.mapper.RaHighCompanyMapper;
import com.bbd.dafei.common.util.Paging;
import com.bbd.dafei.common.modal.vo.RaIndexCompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-04-19.
 */
@Service
public class RaHighCompanyServiceImpl implements RaHighCompanyService {

    @Autowired
    private RaHighCompanyMapper raHighCompanyMapper;
    @Override
    public List<RaIndexCompanyVO> findByProvince(String province,
                                                 String city,
                                                 String area ,
                                                 String industry,
                                                 String isNew) {

        return raHighCompanyMapper.findByProvince(province,city,area ,industry,isNew);

    }

    @Override
    public Paging<RaIndexCompanyVO> query(String province, String city,
                                          String area, String industry,
                                          String isNew,
                                          Integer start, Integer size,
                                          String order, String descAsc) {

        int count = raHighCompanyMapper.count(province,  city,  area,industry,isNew);

        Paging<RaIndexCompanyVO> paging = new Paging<>();

        paging.setCount(count);

        paging.setSize(size);

        paging.setStart(start);

        if(count == 0){
            return paging;
        }

        paging.setRecords(raHighCompanyMapper.query(province, city, area, industry,isNew, start, size,order,descAsc));

        return paging;
    }

}
