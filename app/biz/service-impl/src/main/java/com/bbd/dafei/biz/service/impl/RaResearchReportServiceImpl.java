package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.RaResearchReportService;
import com.bbd.dafei.common.dal.mapper.RaResearchReportMapper;
import com.bbd.dafei.common.dal.po.RaResearchReportPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tuanhong on 2017-04-21.
 */
@Service
@Transactional
public class RaResearchReportServiceImpl implements RaResearchReportService {

    @Autowired
    private RaResearchReportMapper raResearchReportMapper;

    @Override
    public RaResearchReportPO findByUserId(int userId) throws Exception {
        return raResearchReportMapper.findByUserId(userId);
    }

    @Override
    public int updateRemTimeAndUsedTimeById(RaResearchReportPO raResearchReportPO) {
        return raResearchReportMapper.updateRemTimeAndUsedTimeById(raResearchReportPO);
    }

    /**
     * 统计已下载和已申请下载总数
     */
    @Override
    public int countDoneAndApply(Integer userId) {
        return raResearchReportMapper.countDoneAndApply(userId);
    }

    @Override
    public void updateResearchReportRemain(Integer userId, Integer remainTimes) {
        //剩余次数为空，删除协议
        if (remainTimes == null) {
            raResearchReportMapper.deleteRaResearchReport(userId);
            return;
        }

        //更改协议剩余下载次数和总次数
        RaResearchReportPO researchReportPO = raResearchReportMapper.findByUserId(userId);
        if (researchReportPO != null) {
            //剩余下载次数
            researchReportPO.setRemainingNumber(remainTimes);
            //重新计算总次数，总次数=已使用次数+剩余次数
            researchReportPO.setTotalNumber(remainTimes + researchReportPO.getUsedNumber());
            raResearchReportMapper.updateRemTimeAndUsedTimeById(researchReportPO);
        } else {
            researchReportPO = new RaResearchReportPO();
            researchReportPO.setId(userId);
            //剩余下载次数
            researchReportPO.setRemainingNumber(remainTimes);
            //已经使用次数
            researchReportPO.setUsedNumber(0);
            //总次数
            researchReportPO.setTotalNumber(remainTimes);
            raResearchReportMapper.insertRaResearchReport(researchReportPO);
        }

    }
}
