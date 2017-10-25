package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.RaReportDetailService;
import com.bbd.dafei.biz.shared.RaResearchReportService;
import com.bbd.dafei.common.dal.mapper.RaCommunicationInfoMapper;
import com.bbd.dafei.common.dal.mapper.RaCompanyMapper;
import com.bbd.dafei.common.dal.mapper.RaReportDetailMapper;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.dal.po.RaResearchReportPO;
import com.bbd.dafei.common.modal.dto.RaCommunicationInfoDTO;
import com.bbd.dafei.common.modal.dto.RaReportDetailDTO;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.DesUtils;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.PageInfoIgnore;
import org.jboss.resteasy.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tuanhong on 2017-04-21.
 */
@Service
public class RaReportDetailServiceImpl implements RaReportDetailService {

    @Autowired
    private RaResearchReportService researchReportSer;

    @Autowired
    private RaReportDetailMapper reportDetailMapper;

    @Autowired
    private RaCompanyMapper raCompanyMapper;

    @Autowired
    private RaCommunicationInfoMapper raCommunicationInfoMapper;

    @Override
    public Map<String, String> applyResearch(int userId, String username, String companyId, String company) throws Exception {

        Map<String, String> message = new HashMap<String, String>();

        //查核是否有申请研报权限（ra_research_report当中必须有对应的资料）
        RaResearchReportPO raResearchReportPO = researchReportSer.findByUserId(userId);

        if (raResearchReportPO == null) {//未查询到对应用户ID的研报信息，提示无权限下载
            message.put("msg", "对不起，未找到您的协议信息，无权申请产生研报");
            return message;
        } else {
            //查核剩余申请次数必须 >=1
            int remNumber = raResearchReportPO.getRemainingNumber(); //剩余研报可下载次数
            if (remNumber < 1) {
                message.put("msg", "对不起，您可下载研报次数为0");
                return message;
            } else {
                /*查核传入的公司是否存在*/
                RaCompanyPO raCompanyPO = raCompanyMapper.findCompanyById(companyId);
                if (raCompanyPO == null) {
                    message.put("msg", "对不起，您申请研报的公司不存在，请确认后再次输入");
                    return message;
                }

                //是否已申请该公司的研报（有状态为 生成中 的资料）
                int num = reportDetailMapper.getStatusByUserIdAndCompanyId(userId, companyId, Constants.REPORT_STATUS_MAKING);
                if (num != 0) {
                    message.put("msg", "您已经申请过该公司的研报，请耐心等待");
                    return message;
                } else {

                    //发送邮件
                    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
                    //取得发送邮件的系统账户信息
                    List<RaCommunicationInfoDTO> sendUserInfo = this.raCommunicationInfoMapper.getInfoByUserType(Constants.RA_COMMUNICATION_INFO_USER_TYPE_ADMIN, Constants.DATA_STATUS_EFFECT);
                    if (CollectionUtils.isEmpty(sendUserInfo)) {
                        message.put("msg", "未找到邮件发送者信息，请确认是否已经设置相关信息");
                    } else {
                        if (sendUserInfo.size() > 1) {
                            message.put("msg", "有多个有效的邮件发送者，请确保邮件发送者只有一个");
                            return message;
                        }
                    }

                    //取得邮件发送者信息
                    List<RaCommunicationInfoDTO> receiveUserInfo = this.raCommunicationInfoMapper.getInfoByUserType(Constants.RA_COMMUNICATION_INFO_USER_TYPE_USER, Constants.DATA_STATUS_EFFECT);
                    if (CollectionUtils.isEmpty(receiveUserInfo)) {
                        message.put("msg", "未找到邮件接收者信息，请确认是否已经设置相关信息");
                        return message;
                    }

                    javaMailSender.setHost("smtp.bbdservice.com");
                    javaMailSender.setUsername(sendUserInfo.get(0).getUsername());

                    String desKey = sendUserInfo.get(0).getDesKey();
                    DesUtils des = new DesUtils(desKey);//自定义密钥
                    javaMailSender.setPassword(des.decrypt(sendUserInfo.get(0).getPassword()));

                    // 建立邮件消息
                    MimeMessage emailMessage = javaMailSender.createMimeMessage();

                    MimeMessageHelper messageHelper = new MimeMessageHelper(emailMessage, true, "UTF-8");

                    //设置邮件主题
                    messageHelper.setSubject("用户最新研报申请信息");
                    //邮件内容
                    StringBuilder builder = new StringBuilder();
                    builder.append("<html><body>您好！<br />");
                    builder.append("        最新研报申请信息如下：<br />");
                    builder.append("            申请用户:" + username + "<br />");
                    builder.append("            申请时间:" + DateUtil.formatDate(new Date(), "yyyy-MM-dd") + "<br />");
                    builder.append("            剩余申请次数:" + String.valueOf(remNumber-1) + "<br />");
                    builder.append("            企业名称:" + company + "<br />");
                    builder.append("</body></html>");
                    String content = builder.toString();
                    // true 表示启动HTML格式的邮件
                    messageHelper.setText(content, true);

                    // 设置发件人邮箱
                    if (null == sendUserInfo.get(0).getEmail() || sendUserInfo.get(0).getEmail().equals("")) {
                        message.put("msg", "发送者邮件地址为空");
                        return message;
                    } else {
                        messageHelper.setFrom(sendUserInfo.get(0).getEmail());
                    }
                    //设置收件人邮箱
                    String[] toEmailArray = new String[receiveUserInfo.size()];
                    for (int i = 0; i < receiveUserInfo.size(); i++) {
                        if (null == receiveUserInfo.get(i).getEmail() || receiveUserInfo.get(i).getEmail().equals("")) {
                            message.put("msg", "接收者邮件地址为空");
                            return message;
                        } else {
                            toEmailArray[i] = receiveUserInfo.get(i).getEmail();
                        }
                    }
                    messageHelper.setTo(toEmailArray);

                    //发送时间
                    messageHelper.setSentDate(new Date());

                    //产生申请信息
                    RaReportDetailDTO raReportDetailDTO = new RaReportDetailDTO();
                    //用户ID
                    raReportDetailDTO.setUserId(userId);
                    //企业名称
                    raReportDetailDTO.setCompany(company);
                    //企业Id
                    raReportDetailDTO.setCompanyId(companyId);
                    //研报状态
                    raReportDetailDTO.setReportStatus(Constants.REPORT_STATUS_MAKING);
                    //研报上传文件类型
                    raReportDetailDTO.setUploadFileType("");
                    //研报地址
                    raReportDetailDTO.setReportUrl("");
                    //创建时间
                    raReportDetailDTO.setGmtCreate(new Date());
                    //修改时间
                    raReportDetailDTO.setGmtUpdate(new Date());
                    //剩余研报次数
                    raReportDetailDTO.setRemainingNumber(raResearchReportPO.getRemainingNumber() - 1);

                    reportDetailMapper.save(raReportDetailDTO);

                    //剩余申请次数 -1，已下载次数+1
                    RaResearchReportPO new_RaResearchReportPO = new RaResearchReportPO();
                    new_RaResearchReportPO.setId(raResearchReportPO.getId());
                    new_RaResearchReportPO.setRemainingNumber(raResearchReportPO.getRemainingNumber() - 1);
                    new_RaResearchReportPO.setUsedNumber(raResearchReportPO.getUsedNumber() + 1);
                    researchReportSer.updateRemTimeAndUsedTimeById(new_RaResearchReportPO);

                    //发送邮件
                    javaMailSender.send(emailMessage);
                }
            }
        }
        return message;
    }

    @Override
    public String findLastReportStatus(int userId, String companyId) {
        //查询最新研报状态
        String status = reportDetailMapper.findLastReportStatus(userId, companyId);
        //数据库无记录，未申请
        if (status == null) {
            status = Constants.REPORT_STATUS_UN_APPLY;
        }
        return status;
    }

    @Override
    public String findApplyTimeByUserIdAndCompany(int userId, String company, String reportStatus) {
        return reportDetailMapper.findApplyTimeByUserIdAndCompany(userId, company, reportStatus);
    }

    @Override
    public void updateReportStatusByUserIdAndCompany(String newStatus, Date gmtUpdate, String fileType, int userId, String company, String oldStatus) {
        reportDetailMapper.updateReportStatusByUserIdAndCompany(newStatus, gmtUpdate, fileType, userId, company, oldStatus);
    }

    @Override
    public void updateDownTime(String newStatus, Date gmtUpdate, int userId, String companyId, String applyTime) {
        reportDetailMapper.updateDownTime(newStatus, gmtUpdate, userId, companyId, applyTime);
    }

    @Override
    public String findFileType(int reportId) {
        return reportDetailMapper.findFileType(reportId);
    }

    @Override
    public String findReportUrl(int reportId) {
        return reportDetailMapper.findReportUrl(reportId);
    }


    @Override
    public PageInfo<RaReportDetailDTO> query(PageInfoIgnore page) {

        int count = reportDetailMapper.count();

        page.setTotalCount(count);

        page.setItems(reportDetailMapper.query(page));

        return page;

    }


    @Override
    public void updateReportStatusById(Integer id, String reportUrl, String newStatus, String fileType, int userId) {
        reportDetailMapper.updateReportStatusById(id, reportUrl, newStatus, fileType, userId);
    }

}
