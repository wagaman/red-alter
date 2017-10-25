package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.RaCompanyRemarkService;
import com.bbd.dafei.common.dal.mapper.RaCompanyRemarkMapper;
import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.modal.dto.RaCompanyRemarkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wish on 2017/5/2.
 */
@Service
public class RaCompanyRemarkServiceImpl implements RaCompanyRemarkService {

    @Autowired
    private RaCompanyRemarkMapper raCompanyRemarkMapper;

    @Override
    public List<RaCompanyRemarkDTO> findRemarkByCompanyIdAndUserName(String companyId, String platform, String userName) {
        return raCompanyRemarkMapper.findRemarkByCompanyIdAndUserName(companyId, platform, userName);
    }

    public void deleteRemarkById(Integer id, String userName) {
        RaCompanyRemarkDTO raCompanyRemarkDTO = raCompanyRemarkMapper.findRemarkById(id);
        if (raCompanyRemarkDTO == null) {
            throw new CommonException("备注id无效");
        }
        if (!raCompanyRemarkDTO.getUserName().equals(userName)) {
            throw new CommonException("只能删除自己的备注");
        }
        int deleteNum = raCompanyRemarkMapper.deleteRemarkById(id);
        if (deleteNum < 1) {
            throw new CommonException("删除失败");
        }
    }

    public void saveRemark(String companyId, String platform, String userName, String remark) {
        RaCompanyRemarkDTO raCompanyRemarkDTO = new RaCompanyRemarkDTO();
        raCompanyRemarkDTO.setCompanyId(companyId);
        raCompanyRemarkDTO.setPlatform(platform);
        raCompanyRemarkDTO.setUserName(userName);
        raCompanyRemarkDTO.setRemark(remark);
        raCompanyRemarkMapper.insertRemark(raCompanyRemarkDTO);
    }
}
