package com.bbd.dafei.biz.service.impl;


import com.bbd.dafei.biz.shared.RaBlackListFocusService;
import com.bbd.dafei.common.dal.mapper.MyReportMapper;
import com.bbd.dafei.common.dal.mapper.RaBlackListFocusMapper;
import com.bbd.dafei.common.dal.mapper.RaBlackListMapper;
import com.bbd.dafei.common.dal.mapper.RaCompanyMapper;
import com.bbd.dafei.common.dal.po.RaBlacklistPO;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.dal.po.RaMyFocusPO;
import com.bbd.dafei.common.modal.dto.BlackFocusNumDTO;
import com.bbd.dafei.common.modal.dto.CommonDTO;
import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.vo.RaBlackListFocusVO;
import com.bbd.dafei.common.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * Created by tuanhong on 2017-04-23.
 */
@Service
public class RaBlackListFocusServiceImpl implements RaBlackListFocusService {

    @Autowired
    private RaBlackListFocusMapper raBlackListFocusMapper;

    @Autowired
    private RaBlackListMapper raBlackListMapper;

    @Autowired
    private RaCompanyMapper raCompanyMapper;

    @Autowired
    private MyReportMapper myReportMapper;


    @Override
    public List<RaBlackListFocusVO> findByUsernameForExport(String username) throws Exception {
        return raBlackListFocusMapper.findByUsernameForExport(username);
    }

    @Override
    public int countFocusByUserId(String username) {
        return raBlackListFocusMapper.countFocusByUsername(username);
    }

    @Override
    public PageInfo queryRiskChange(String username, PageInfo p) {

        p.setTotalCount(raBlackListFocusMapper.countRiskChange(username));

        if (p.getTotalCount() < 0) {
            return p;
        }

        p.setItems(raBlackListFocusMapper.queryRiskChange(username, p));

        return p;
    }

    @Override
    public BlackFocusNumDTO findBlackAndFocusNum(String companyId, String userName, String province) {
        BlackFocusNumDTO blackFocusNumDTO = new BlackFocusNumDTO();
        RaCompanyPO raCompanyPO = raCompanyMapper.findCompanyById(companyId);
        blackFocusNumDTO.setRaCompanyPO(raCompanyPO);
        //同一区域所有用户对该公司和关注数
        int focusNum = raBlackListFocusMapper.findFocusNumByCompanyIdAndProvince(companyId, province);
        //该用户对该公司的关注信息
        RaMyFocusPO myFocusPO = raBlackListFocusMapper.findLastedFocusByCompanyIdAndUserName(companyId, userName);
        //公司拉黑信息
        RaBlacklistPO raBlacklistPO = raBlackListMapper.findLastBlackByCompanyId(companyId);

        //如果有关注信息，设置关注状态和关注id
        if (myFocusPO != null) {
            blackFocusNumDTO.setUserFocus(true);
            blackFocusNumDTO.setFocusId(myFocusPO.getId());
        }

        if (raBlacklistPO != null) {
            blackFocusNumDTO.setBlack(true);
            blackFocusNumDTO.setBlackId(raBlacklistPO.getId());
            blackFocusNumDTO.setAddBlackDate(raBlacklistPO.getJoinDate());
            //拉黑原因
            List<String> reasons = raBlackListMapper.findBlackReasonsByBlackId(raBlacklistPO.getId());
            blackFocusNumDTO.setBlackReasons(reasons);
        }

        blackFocusNumDTO.setFocusNum(focusNum);

        return blackFocusNumDTO;
    }

    /**
     * 根据id设置关注企业中有风险变动的企业的状态为已查看
     *
     * @param id
     * @return
     */
    public void updateLookOverById(Integer id) {
        raBlackListFocusMapper.updateLookOver(id, 1);
    }

    /**
     * 设置所有关注企业中有风险变动的企业的状态为未查看
     *
     * @param status
     * @return
     */
    public void updateLookOver(Integer status) {
        raBlackListFocusMapper.updateLookOver(null, 0);
    }

    @Override
    public PageInfo queryMyFocus(PageInfo p, int type, String username, String industry, String riskLevel, String order, String descAsc) {

        int count = raBlackListFocusMapper.countMyFocus(type, username, industry, riskLevel);

        p.setTotalCount(count);

        if (count == 0) {
            return p;
        }

        p.setItems(raBlackListFocusMapper.queryMyFocus(p, type, username, industry, riskLevel, order, descAsc));


        return p;
    }

    @Override
    public void cancelFocus(Integer id, Integer blackChangeLook) {
        raBlackListFocusMapper.cancelFocus(id, blackChangeLook);
    }


    public int countBlackByUserId(String username) {
        return raBlackListFocusMapper.countBlackByUserId(username);
    }

    @Override
    public void addFocus(String username, String companyId, String companyName, List<KeyValDTO<Integer, String>> addReasons) {

        int count = raBlackListFocusMapper.isFocusByUser(username, companyId);
        if (count != 0) {
            return;
        }

        CommonDTO vo = new CommonDTO();
        vo.setCompany(companyName);
        vo.setCompanyId(companyId);
        vo.setUsername(username);

        raBlackListFocusMapper.addFocus(vo);

        if (!CollectionUtils.isEmpty(addReasons))
            raBlackListFocusMapper.addFocusReasons(companyId, vo.getId(), addReasons);


    }


    @Override
    public void lookBlackChangeCancelFoucs(Integer id) {

        raBlackListFocusMapper.lookBlackChangeCancelFoucs(id);

    }
}
