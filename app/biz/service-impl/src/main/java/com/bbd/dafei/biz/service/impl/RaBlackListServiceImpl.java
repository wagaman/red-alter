package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.service.sys.SystemThreadPool;
import com.bbd.dafei.biz.shared.RaAreaCountService;
import com.bbd.dafei.biz.shared.RaBlackListService;
import com.bbd.dafei.biz.shared.RaCompanyService;
import com.bbd.dafei.common.dal.mapper.*;
import com.bbd.dafei.common.dal.po.RaBlacklistPO;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.modal.commonenum.BlackReasonTypeEnum;
import com.bbd.dafei.common.modal.dto.BlackWhiteDTO;
import com.bbd.dafei.common.modal.dto.BlacklistAddDTO;
import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.vo.*;
import com.bbd.dafei.common.util.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by tuanhong on 2017-04-20.
 */
@Service
@Transactional
public class RaBlackListServiceImpl implements RaBlackListService {

    Logger logger = LoggerFactory.getLogger(RaBlackListServiceImpl.class);

    @Autowired
    private RaBlackListMapper raBlackListMapper;


    @Autowired
    private RaCompanyMapper companyMapper;


    @Autowired
    private RaBlackListFocusMapper raBlackListFocusMapper;

    @Autowired
    private RaHighCompanyMapper highCompanyMapper;

    @Autowired
    private RaAreaCountMapper areaCountMapper;

    @Autowired
    private RaAreaCountService raAreaCountService;

    @Override
    public List<RaBlackListVO> getDataForExcel(String province, String city, String area, String industry) {
        return raBlackListMapper.getDataForExcel(province, city, area, industry);
    }

    @Override
    public List<RaBlackListFocusVO> getDataForPersonExcel(String province, String username) {
        return raBlackListMapper.getDataForPersonExcel(province, username);
    }

    @Override
    public PageInfo<RaBlackListVO> query(String username, String province,
                                         String city, String area,
                                         String industry, String riskLevel,
                                         Integer start, Integer size,
                                         String order, String descAsc) {

        int count = raBlackListMapper.count(username, province,
                city, area,
                industry, riskLevel,
                0);

        PageInfo<RaBlackListVO> paging = new PageInfo<>();

        paging.setTotalCount(count);

        paging.setPageSize(size);

        paging.setStart(start);

        if (count == 0) {
            return paging;
        }

        paging.setItems(raBlackListMapper.query(username, province,
                city, area,
                industry, riskLevel,
                0, start, size,
                order, descAsc));
        return paging;
    }


    /**
     * 分页查询我的黑名单和被他人取消但未被查看的企业
     */
    public PageInfo<RaBlackListVO> queryAddCancel(String username, String province,
                                                  String city, String area,
                                                  String industry, String riskLevel,
                                                  Integer start, Integer size,
                                                  String order, String descAsc) {

        int count = raBlackListMapper.countAddAndCancel(username, province,
                city, area,
                industry, riskLevel,
                0);

        PageInfo<RaBlackListVO> paging = new PageInfo<>();

        paging.setTotalCount(count);

        paging.setPageSize(size);

        paging.setStart(start);

        if (count == 0) {
            return paging;
        }

        paging.setItems(raBlackListMapper.queryAddAndCancel(username, province,
                city, area,
                industry, riskLevel,
                0, start, size,
                order, descAsc));
        return paging;


    }
    @Override
    public int getExportTotal(String username, String province,
                              String city, String area,
                              String industry, String riskLevel,
                              Integer start, Integer size,
                              String order, String descAsc) {

        List<RaBlackListVO> raBlackListVOS= raBlackListMapper.queryAddAndCancel(username, province, city, area,industry, riskLevel,0, start, size,order, descAsc);

        int totalNumber = 0;
        for(RaBlackListVO raBlackListVO: raBlackListVOS){
            String status = raBlackListVO.getStatus();

            if(status.equals("0")){
                totalNumber++;
            }
        }
        return totalNumber;
    }

    public void cancelBlack(Integer id, String companyId, List<KeyValDTO<Integer, String>> cancelReason,
                            String cancelUser, Date cancelDate, boolean cancelByUser) {


        raBlackListMapper.cancelBlack(id, companyId, cancelReason, cancelUser, cancelDate, cancelByUser);


        // 被移除的黑名单企业如果是高危企业则加入高危企业列表
        RaCompanyPO po = companyMapper.findCompanyById(companyId);
        if (po == null) {
            return;
        }
        if ("高危预警".equals(po.getRiskLevel())) {

            highCompanyMapper.addHighCompany(po);
            areaCountMapper.addHigh(po.getProvince(), po.getCity(), po.getArea(), 1);
        }

        //更新持续监控 和重点关注统计数量(移除黑名单，数量加1)
        raAreaCountService.updateAreaCountNum(po,1);

        //更新ra_company表中isBlack为 0
        Set<String> companyIds = new HashSet<>();
        companyIds.add(po.getId());
        companyMapper.updateIsBlackById(companyIds,0);
    }

    public List<String> findBlackListByCompanyIds(Set<String> companyIds) {
        if (CollectionUtils.isEmpty(companyIds)) {
            return new ArrayList<>();
        }
        return raBlackListMapper.findBlackListByCompanyIds(companyIds);
    }


    public void addBlacklist(String username, String companyId,
                             String company, String province,
                             String city, String area,
                             Date joinDate, short joinType,
                             List<KeyValDTO<Integer, String>> addReasons) {

        synchronized (companyId.intern()) {

            int count = raBlackListMapper.inBlacklist(companyId);

            if (count != 0) {
                throw new CommonException("该公司已在黑名单中，不能重复添加");
            }

            RaCompanyPO po = companyMapper.findCompanyById(companyId);

            if (StringUtils.isEmpty(province) || "无".equals(province)) {
                province = po == null ? "无" : po.getProvince();
            }

            if (StringUtils.isEmpty(city) || "无".equals(city)) {
                city = po == null ? "无" : po.getCity();
            }

            if (StringUtils.isEmpty(area) || "无".equals(area)) {
                area = po == null ? "无" : po.getArea();
            }

            BlacklistAddDTO dto = new BlacklistAddDTO();
            dto.setUsername(username);
            dto.setCompanyId(companyId);
            dto.setCompany(company);
            dto.setProvince(province);
            dto.setCity(city);
            dto.setArea(area);
            dto.setJoinDate(joinDate);
            dto.setJoinType(joinType);
            raBlackListMapper.addBlacklist(dto);
            raBlackListMapper.addBlacklistReasons(companyId, dto.getId(), null, addReasons);

            //移除高危企业列表
            int deletCount = highCompanyMapper.deleteByCompanyId(companyId);

            if (deletCount > 0 && po != null) {
                areaCountMapper.addHigh(po.getProvince(), po.getCity(), po.getArea(), -1);
            }

            //移除关注列表
            StringBuilder cancelFocusReason = new StringBuilder();
            if (!CollectionUtils.isEmpty(addReasons)) {
                addReasons.forEach(reaons -> {
                    cancelFocusReason.append(cancelFocusReason.length() == 0 ? "" : "、").append(reaons.getV());
                });
            }
            cancelFocusByCompanyId(companyId, cancelFocusReason.toString());

            if(po != null){
                //更新持续监控 和重点关注统计数量(加入黑名单，数量减1)
                raAreaCountService.updateAreaCountNum(po,-1);
                //加入黑名单后更新ra_company表中的isBlack 为1
                Set<String> companyIds = new HashSet<>();
                companyIds.add(po.getId());
                companyMapper.updateIsBlackById(companyIds,1);
            }
        }

    }

    @Override
    public void addBlacklistManage(String username, String companyId,
                                   String company, String province,
                                   String city, String area,
                                   Date joinDate, short joinType,
                                   List<KeyValDTO<Integer, String>> addReasons) {
        int exist = raBlackListMapper.isexist(companyId);
        if (exist > 0) {
            throw new CommonException("该公司已在黑名单中，不能重复添加");
        }
        addBlacklist(username, companyId, company, province, city, area, joinDate, joinType, addReasons);
    }

    public void cancelFocusByCompanyId(String companyId, String reasons) {


        // 移除我的关注
        List<Integer> focusIds = raBlackListFocusMapper.queryFocusByCompanyId(companyId);

        focusIds.forEach(focusId -> {

            KeyValDTO<Integer, String> kv = new KeyValDTO<>(4, reasons);
            raBlackListFocusMapper.addFocusReasons(companyId, focusId, Arrays.asList(kv));
            raBlackListFocusMapper.cancelFocus(focusId, 0);

        });


    }


    public void lookOverCancel(String username, Integer id) {
        raBlackListMapper.lookOverCancel(username, id);
    }


    @Override
    public void initBlack() throws Exception {

        companyToBlacklist();

        deleteHighCompanyByBlacklist();

        blacklistCancelFocus();

        /**
         * 由于ra_blacklist这个表 是 后端在维护，数据更新不会更新这个表
         * 再加上以前由于程序问题有可能出现province 为无的状况，程序修改后资料不会出现这样的数据
         * 所以在初始化黑名单的时候，根据企业id 更新一下黑名单表当中 province = ‘无’的这种资料
         * 让黑名单中 省市区与企业表中保持一致
         */
        updateRaBlackListProvinceCityArea();

        //根据黑名单表，更新监控统计表，修改company表中isBlack
        modifyAreaCountAndCompany();

    }

    private void updateRaBlackListProvinceCityArea() {
        raBlackListMapper.updateProvinceCityArea();
    }

    private void modifyAreaCountAndCompany() {
        //取得黑名单的数据
        List<RaBlacklistPO> raBlacklistPOS = raBlackListMapper.findAll();

        if(CollectionUtils.isEmpty(raBlacklistPOS)){
            return;
        }

        /**
         * 逐个判断黑名单是否存在于ra_company
         * 存在，则更新对应的ra_company的数据的isBlack为1，在被更新的资料当中如果行业 风险等级为  持续监控 或者重点关注，则需修改统计表中对应的数据
         * 如果不存在，则不用处理
         * */
        Set<String> companyIds = new HashSet<>();
        for(RaBlacklistPO raBlacklistPO:raBlacklistPOS){
            companyIds.add(raBlacklistPO.getCompanyId());
        }

        //更新ra_company的isBlack为1
        companyMapper.updateIsBlackById(companyIds,1);

        List<RaCompanyPO> raCompanyPOS = companyMapper.findCompanysByIds(companyIds);

        for(RaCompanyPO raCompanyPO:raCompanyPOS){
            raAreaCountService.updateAreaCountNum(raCompanyPO,-1);
        }
    }


    /**
     * 根据黑名单列表删除高危企业的计算
     */
    private void deleteHighCompanyByBlacklist() {

        raBlackListFocusMapper.deleteHighCompanyByBlacklist();

    }


    /**
     * 根据黑名单列表取消关注
     */
    private void blacklistCancelFocus() {

        raBlackListFocusMapper.blacklistCancelFocus();

    }


    /**
     * 从网络爬取数据移动到黑名单列表的计算
     */
    private void companyToBlacklist() throws Exception {


        int size = 100;

        int count = raBlackListFocusMapper.countBlackWhite();

        CountDownLatch latch = new CountDownLatch((count + size - 1) / size);

        int start = 0;

        while (true) {

            List<BlackWhiteDTO> list = raBlackListFocusMapper.queryBlackWhite(start, size);

            if (!CollectionUtils.isEmpty(list))
                computeBlack(list, latch);

            if (list.size() < size) {
                break;
            }
            start = start + size;
        }

        latch.await();

    }


    private void computeBlack(List<BlackWhiteDTO> blacklist, CountDownLatch latch) {
        SystemThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    blacklist.forEach(dto -> {
                        if (1 == dto.getIsBlack()) {// 黑名单企业
                            netBlackCompany(dto);
                        } else { //白名单企业
                            netWhiteCompany(dto);
                        }

                    });
                } catch (Exception e) {
                    logger.error("初始化黑名单报错", e);
                }


                latch.countDown();
            }
        });
    }


    /**
     * 网络爬取的黑名单
     */
    private void netBlackCompany(BlackWhiteDTO dto) {

        int isexist = raBlackListMapper.isexist(dto.getId());

        if (isexist > 0) {
            return;
        }

        addBlacklist(dto.getJoinSouce(),
                dto.getId(),
                dto.getCompany(),
                dto.getProvince(),
                dto.getCity(),
                dto.getArea(),
                dto.getJoinDate(),
                Constants.BLACKLIST_JOIN_TYPE_NET,
                Arrays.asList(new KeyValDTO(2, "" + dto.getReason())));

    }


    /**
     * 网络爬取的正常企业名单
     */
    private void netWhiteCompany(BlackWhiteDTO dto) {

    }


    public Integer findBlackListByCompanyId(String companyId) {
        return raBlackListMapper.findBlackListByCompanyId(companyId);
    }

    @Override
    public WrodBlackListInfoVO getBlackListInfoByCompanyId(String companyId) {
        return raBlackListMapper.getBlackListInfoByCompanyId(companyId);
    }

    @Override
    public PageInfoIgnore queryAndReason(String company, String order, String ascDesc, PageInfoIgnore pageInfo) {

        Map<String, Object> map = new HashMap();

        map.put("company", company);
        map.put("page", pageInfo);
        map.put("order", order);
        map.put("ascDesc", ascDesc);

        pageInfo.setItems(raBlackListMapper.queryAndReasonPage(map));

        return pageInfo;
    }

    public List<BlacklistVO> queryAndReasonByIds(List<Integer> ids, String order, String ascDesc) {
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }
        return raBlackListMapper.queryAndReasonByIds(ids, order, ascDesc);
    }


    public ResponseBean<Workbook> importBlacklist(File excel) throws Exception {

        InputStream is = new FileInputStream(excel);

        ExcelReader excelReader = new ExcelReader();

        String[] titles = {"企业名", "ID", "列入黑名单原因", "黑名单来源", "列入黑名单日期"};

        if (!excelReader.checkTitleOrder(is, titles)) {
            return ResponseBean.errorResponse(203, "导入失败,列表题正确顺序为:" + Arrays.toString(titles));
        }
        is.close();
        is = new FileInputStream(excel);
        Map<Integer, String[]> content = excelReader.readExcelContent(is);
        is.close();
        Map<Integer, String> checkResult = checkData(content.values());

        if (checkResult.size() > 0) {
            is = new FileInputStream(excel);
            Workbook workbook = excelReader.markRowRed(is, checkResult);
            is.close();
            return ResponseBean.errorResponse(203, "导入失败", workbook);
        }

        addBlacklist(content.values());

        return ResponseBean.successResponse(null, "黑名单导入成功");
    }


    /**
     * 将数据写入黑名单库
     *
     * @param values 企业信息数组,顺序为:{"企业名", "ID", "列入黑名单原因", "黑名单来源", "列入黑名单日期"}
     */
    private void addBlacklist(Collection<String[]> values) {
        values.forEach(vals -> {
            String id = StringUtils.trimAllWhitespace(vals[1]);
            RaCompanyPO po = companyMapper.findCompanyById(id);
            String province = po == null ? "无" : po.getProvince();
            String city = po == null ? "无" : po.getCity();
            String area = (po == null ? "无" : po.getArea());
            Date joinDate = null;
            if (StringUtils.hasText(vals[4])) {
                try {
                    joinDate = DateUtils.parseDate(StringUtils.trimAllWhitespace(vals[4]), "yyyyMMdd", "yyyy-MM-dd", "yyyy/MM/dd");
                } catch (ParseException e) {
                    logger.error("转换加入时间失败", e);
                }
            }
            addBlacklist(vals[3], id, vals[0], province, city, area, joinDate, Constants.BLACKLIST_JOIN_TYPE_IMPORT, Arrays.asList(new KeyValDTO<>(BlackReasonTypeEnum.ADD_REASON_OTHER.getCode(), vals[2])));
        });
    }


    /**
     * 检查数据id 与 重复的问题
     *
     * @param values 企业信息数组 ,顺序为:{"企业名", "ID", "列入黑名单原因", "黑名单来源", "列入黑名单日期"}
     * @return 返回验证的错误信息, 为空时表示验证通过
     */
    private Map<Integer, String> checkData(Collection<String[]> values) {

        Map<Integer, String> result = new HashMap<>();
        AtomicInteger index = new AtomicInteger(0);
        values.forEach(vals -> {
            index.incrementAndGet();
            String id = StringUtils.trimAllWhitespace(vals[1]);

            if (!StringUtils.hasText(id)) {
                result.put(Integer.valueOf(index.get()), "ID不能为空");
                return;
            }

            int isexist = raBlackListMapper.isexist(id);
            if (isexist > 0) {
                result.put(Integer.valueOf(index.get()), "与数据库中黑名单重复");
            }
        });

        return result;
    }

    @Override
    public void deleteBlackListByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            throw new CommonException("删除黑名单失败，id不能为空");
        }
        List<RaBlacklistPO> blacklistPOList = raBlackListMapper.findBlacklistsByIds(ids);
        if (CollectionUtils.isNotEmpty(blacklistPOList)) {
            //黑名单中的企业id
            Set<String> companyIds = new HashSet<>();
            blacklistPOList.forEach(blacklistPO -> companyIds.add(blacklistPO.getCompanyId()));

            if (CollectionUtils.isNotEmpty(companyIds)) {
                //根据公司id批量查询本地库中的企业
                List<RaCompanyPO> companyPOList = companyMapper.findCompanysByIds(companyIds);


                //线程1 高危预警处理
                SystemThreadPool.execute(() -> {
                    List<RaCompanyPO> highRiskCompanys = companyPOList.stream()
                            .filter(raCompanyPO -> "高危预警".equals(raCompanyPO.getRiskLevel()))
                            .collect(Collectors.toList());

                    if (CollectionUtils.isNotEmpty(highRiskCompanys)) {
                        //将高危预警的企业批量添加到高危企业表
                        highCompanyMapper.addHighCompanys(highRiskCompanys);
                        //异步更新ra_area_count中的数量
                        highRiskCompanys.forEach(po -> SystemThreadPool.execute(() -> areaCountMapper.addHigh(po.getProvince(), po.getCity(), po.getArea(), 1)));
                    }
                });

                //线程 2 持续监控 与重点关注 处理
                SystemThreadPool.execute(() ->{
                    //重点关注 与持续监控 企业列表
                    List<RaCompanyPO> sustainMonitorFocusOnCompanys =  companyPOList.stream()
                            .filter(raCompanyPO -> Constants.RISK_LEVEL_FOCUS_ON.equals(raCompanyPO.getRiskLevel()) || Constants.RISK_LEVEL_SUSTAIN_MONITOR.equals(raCompanyPO.getRiskLevel()))
                            .collect(Collectors.toList());
                    if(CollectionUtils.isNotEmpty(sustainMonitorFocusOnCompanys)){
                        //异步更新 持续监控 和重点关注统计数量(删除黑名单，数量加1)
                        sustainMonitorFocusOnCompanys.forEach(raCompanyPO -> SystemThreadPool.execute(() -> raAreaCountService.updateAreaCountNum(raCompanyPO,1)));
                    }
                });

                //线程 3 更新企业表中 isBlack 为 0
                SystemThreadPool.execute(()->{
                    companyMapper.updateIsBlackById(companyIds,0);
                });

            }
        }



        raBlackListMapper.deleteBlacklistByIds(ids);
        raBlackListMapper.deleteBlackReasonsByBlackIds(ids);

    }

    @Override
    public void deleteBlackListById(Integer id) {
        RaBlacklistPO raBlacklistPO = raBlackListMapper.findBlacklistById(id);
        if (raBlacklistPO == null) {
            throw new CommonException("黑名单id无效");
        }
        // 被移除的黑名单企业如果是高危企业则加入高危企业列表
        RaCompanyPO po = companyMapper.findCompanyById(raBlacklistPO.getCompanyId());
        if (po != null && "高危预警".equals(po.getRiskLevel())) {
            synchronized (String.valueOf(po.getId()).intern()) {
                highCompanyMapper.addHighCompany(po);
                areaCountMapper.addHigh(po.getProvince(), po.getCity(), po.getArea(), 1);
            }
        }
        //删除黑名单
        raBlackListMapper.deleteBlacklistById(id);
        //删除黑名单原因
        raBlackListMapper.deleteBlackReasonByBlackId(id);

    }


    @Override
    public void updateBlacklist(Integer blackId, String username,
                                Date joinDate,
                                String addReason,
                                Date cancelDate,
                                String cancelReason) {


        RaBlacklistPO raBlacklistPO = raBlackListMapper.findBlacklistById(blackId);
        if (raBlacklistPO == null) {
            throw new CommonException("黑名单id无效");
        }

        //修改黑名单
        raBlackListMapper.updateBlacklist(blackId, username, joinDate);
        //删除原因
        raBlackListMapper.deleteBlackReasonByBlackId(blackId);
        //重新添加原因
        List<KeyValDTO<Integer, String>> reasons = new ArrayList<>();
        KeyValDTO addKeyValDTO = new KeyValDTO();
        //加入黑名单原因：其他
        addKeyValDTO.setK(BlackReasonTypeEnum.ADD_REASON_OTHER.getCode());
        addKeyValDTO.setV(addReason);
        reasons.add(addKeyValDTO);
        //黑名单是取消状态
        if (raBlacklistPO.getStatus() == 1) {
            KeyValDTO cancelKeyValDTO = new KeyValDTO();
            //取消黑名单原因：其他
            cancelKeyValDTO.setK(BlackReasonTypeEnum.CANCEL_REASON_OTHER.getCode());
            cancelKeyValDTO.setV(cancelReason);
            reasons.add(cancelKeyValDTO);
        }

        raBlackListMapper.addBlacklistReasons(raBlacklistPO.getCompanyId(), blackId, cancelDate, reasons);
    }

    @Override
    public void deleteAllBlacklist() {
        List<BlacklistVO> blacklistVOList = raBlackListMapper.findAllBlackList();
        deleteBlackLists(blacklistVOList);
    }

    @Override
    public void deleteAllManagedBlackList() {
        List<BlacklistVO> blacklistVOList = raBlackListMapper.findAllManagedBlackList();
        deleteBlackLists(blacklistVOList);
    }

    @Override
    public void deleteBlackLists(List<BlacklistVO> blacklistVOList) {
        if (CollectionUtils.isNotEmpty(blacklistVOList)) {
            List<Integer> blacklistIds = new ArrayList<>();
            for (BlacklistVO blacklistVO : blacklistVOList) {
                blacklistIds.add(blacklistVO.getId());
            }
            deleteBlackListByIds(blacklistIds);
        }
    }

    @Override
    public PageInfo<BlacklistVerifyVO> findBlackListVerifyPage(int page, int pageSize, String type) {
        PageInfo<BlacklistVerifyVO> pageInfo = new PageInfo<>(page, pageSize);
        List<BlacklistVerifyVO> list = raBlackListMapper.findBlackListVerifyPage(pageInfo, type);
        pageInfo.setItems(list);
        return pageInfo;
    }


}
