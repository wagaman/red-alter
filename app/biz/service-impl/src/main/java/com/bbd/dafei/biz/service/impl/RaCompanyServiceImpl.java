package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.RaCompanyService;
import com.bbd.dafei.common.dal.mapper.RaCompanyMapper;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.modal.vo.RaCompanyVO;
import com.bbd.dafei.common.modal.vo.RaIndexCompanyVO;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.PageInfoIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by tuanhong on 2017-04-23.
 */
@Service
public class RaCompanyServiceImpl implements RaCompanyService {

    @Autowired
    private RaCompanyMapper raCompanyMapper;

    @Override
    public RaCompanyVO getRadarByCompany(String company) throws Exception {
        RaCompanyVO raCompanyVO = null;

        if (StringUtils.isEmpty(company)) {
            throw new CommonException("企业名称空白");
        } else {
            raCompanyVO = raCompanyMapper.getRadarByCompany(company);
        }
        return raCompanyVO;
    }

    @Override
    public RaCompanyVO getRadarByCompanyId(String companyId) throws Exception {
        RaCompanyVO raCompanyVO = null;

        if (StringUtils.isEmpty(companyId)) {
            throw new CommonException("企业ID空白");
        } else {
            raCompanyVO = raCompanyMapper.getRadarByCompanyId(companyId);
        }
        return raCompanyVO;
    }

    @Override
    public RaCompanyVO getScanByCompany(String company) throws Exception {
        RaCompanyVO raCompanyVO = null;

        if (StringUtils.isEmpty(company)) {
            throw new CommonException("企业名称空白");
        } else {
            raCompanyVO = raCompanyMapper.getScanByCompany(company);
        }
        return raCompanyVO;
    }

    @Override
    public RaCompanyVO getScanByCompanyId(String companyId) throws Exception {
        RaCompanyVO raCompanyVO = null;

        if (StringUtils.isEmpty(companyId)) {
            throw new CommonException("企业ID空白");
        } else {
            raCompanyVO = raCompanyMapper.getScanByCompanyId(companyId);
        }
        return raCompanyVO;
    }

    @Override
    public RaCompanyVO getSortByCompany(String company) throws Exception {
        RaCompanyVO raCompanyVO = null;

        if (StringUtils.isEmpty(company)) {
            throw new CommonException("企业名称空白");
        } else {
            raCompanyVO = raCompanyMapper.getSortByCompany(company);
        }
        return raCompanyVO;
    }

    @Override
    public RaCompanyVO getSortByCompanyId(String companyId) throws Exception {
        RaCompanyVO raCompanyVO = null;

        if (StringUtils.isEmpty(companyId)) {
            throw new CommonException("企业ID空白");
        } else {
            raCompanyVO = raCompanyMapper.getSortByCompanyId(companyId);
        }
        return raCompanyVO;
    }

    @Override
    public RaCompanyPO findCompanyByName(String companyName) {
        return raCompanyMapper.findCompanyByName(companyName);
    }

    @Override
    public RaCompanyPO findCompanyById(String companyId) {
        return raCompanyMapper.findCompanyById(companyId);
    }

    @Override
    public List<RaCompanyPO> findCompanysByIds(Set<String> companyIds) {
        if (CollectionUtils.isEmpty(companyIds)) {
            return new ArrayList<RaCompanyPO>();
        }
        return raCompanyMapper.findCompanysByIds(companyIds);
    }

    @Override
    public PageInfo<RaCompanyPO> search(PageInfoIgnore page, String keyword){

        int count = raCompanyMapper.searchCount(keyword);

        page.setTotalCount(count);

        page.setItems(raCompanyMapper.search( page, keyword));

        return page;
    }

    @Override
    public List<RaCompanyPO> search(String keyword){

        PageInfoIgnore page = new PageInfoIgnore();
        page.setPage(1);
        page.setPageSize(20);

        return (raCompanyMapper.search( page, keyword));


    }

    @Override
    public PageInfo<RaIndexCompanyVO> findIndexCompanyPage(String province, String city,
                                     String area, String industry, String riskLevel,
                                     Integer page, Integer pageSize,
                                     String order, String descAsc) {

        PageInfo pageInfo = new PageInfo(page, pageSize);
        Map<String,Object> params = new HashMap<>();
        params.put("province", province);
        params.put("city", city);
        params.put("area", area);
        params.put("industry", industry);
        params.put("riskLevel",riskLevel);
        params.put("order", order);
        params.put("descAsc", descAsc);
        params.put("page", pageInfo);
        List<RaIndexCompanyVO> list = raCompanyMapper.findIndexCompanyPage(params);
        pageInfo.setItems(list);
        return pageInfo;

    }

}
