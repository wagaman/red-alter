package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.vo.*;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.PageInfoIgnore;
import com.bbd.dafei.common.util.ResponseBean;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by tuanhong on 2017-04-20.
 */
public interface RaBlackListService {

    /**
     * 查询黑名单(导出EXCEL)
     *
     * @param province
     * @param city
     * @param area
     * @param industry
     * @return
     */
    public List<RaBlackListVO> getDataForExcel(String province, String city, String area, String industry);

    /*
     *查询我的黑名单(个人中心 -- 导出EXCEL)
     *  */
    public List<RaBlackListFocusVO> getDataForPersonExcel(String province, String username);

    /**
     * 分页查询黑名单
     */
    public PageInfo<RaBlackListVO> query(String username, String province,
                                         String city, String area,
                                         String industry, String riskLevel,
                                         Integer start, Integer size,
                                         String order, String descAsc);


    /**
     * 分页查询我的黑名单和被他人取消但未被查看的企业
     */
    public PageInfo<RaBlackListVO> queryAddCancel(String username, String province,
                                                  String city, String area,
                                                  String industry, String riskLevel,
                                                  Integer start, Integer size,
                                                  String order, String descAsc);


    /**
     * 移除黑名单
     *
     * @param id           黑名单id
     * @param companyId    公司id
     * @param cancelReason 移除原因
     * @param cancelUser   移除用户
     * @param cancelDate   移出时间，为空取数据库当前时间
     * @param cancelByUser 是否由前台用户移除，前台用户移除，将该黑名单标记为前台用户加入
     */
    void cancelBlack(Integer id, String companyId, List<KeyValDTO<Integer, String>> cancelReason, String cancelUser, Date cancelDate, boolean cancelByUser);

    /**
     * 根据公司id批量查询在黑名单中的公司id
     *
     * @param companyIds
     * @return
     */
    List<String> findBlackListByCompanyIds(Set<String> companyIds);

    void addBlacklist(String username, String companyId,
                      String company, String province,
                      String city, String area,
                      Date joinDate, short joinType,
                      List<KeyValDTO<Integer, String>> addReasons);

    /**
     * 后台添加黑名单
     *
     * @param username
     * @param companyId
     * @param company
     * @param province
     * @param city
     * @param area
     * @param joinDate
     * @param joinType
     * @param addReasons
     */
    void addBlacklistManage(String username, String companyId,
                            String company, String province,
                            String city, String area,
                            Date joinDate, short joinType,
                            List<KeyValDTO<Integer, String>> addReasons);


    /**
     * 查看 被他人取消黑名单 的状态修改
     *
     * @param username
     * @param id
     * @return
     */
    void lookOverCancel(String username, Integer id);


    /**
     * 初始化黑名单,主要是网络爬取出来的数据状态发送了改变要做提示
     */
    void initBlack() throws Exception;


    /**
     * 根据企业ID查找处于黑名单状态的ID
     *
     * @param companyId 企业ID
     * @return void
     */
    Integer findBlackListByCompanyId(String companyId);


    /**
     * 根据企业ID查询被加入黑名单原因时间等信息
     *
     * @param companyId
     * @return
     */
    WrodBlackListInfoVO getBlackListInfoByCompanyId(String companyId);


    /**
     * 根据企业名称分页查询
     *
     * @param company  被搜索的企业名称
     * @param order    排序字段
     * @param ascDesc  排序方式
     * @param pageInfo 分页信息
     * @return
     */
    PageInfoIgnore queryAndReason(String company, String order, String ascDesc, PageInfoIgnore pageInfo);

    /**
     * 根据id集合查询黑名单
     *
     * @param ids     id集合
     * @param order   排序字段
     * @param ascDesc 排序方式
     * @return
     */
    List<BlacklistVO> queryAndReasonByIds(List<Integer> ids, String order, String ascDesc);


    ResponseBean<Workbook> importBlacklist(File excel) throws Exception;

    /**
     * 批量删除黑名单，删除黑名单之前先取消黑名单，还原到高危企业
     *
     * @param ids
     */
    void deleteBlackListByIds(List<Integer> ids);

    /**
     * 删除黑名单，删除黑名单之前先取消黑名单，还原到高危企业
     *
     * @param id
     */
    void deleteBlackListById(Integer id);

    /**
     * 修改黑名单
     *
     * @param blackId
     * @param username
     * @param joinDate
     * @param addReason
     * @param cancelDate
     * @param cancelReason
     */
    void updateBlacklist(Integer blackId, String username,
                         Date joinDate,
                         String addReason,
                         Date cancelDate,
                         String cancelReason);

    /**
     * 删除所有黑名单
     *
     * @return
     */
    void deleteAllBlacklist();

    /**
     * 删除所有非用户添加的黑名单
     *
     * @return
     */
    void deleteAllManagedBlackList();

    /**
     * 删除黑名单
     *
     * @param blacklistVOList
     */
    void deleteBlackLists(List<BlacklistVO> blacklistVOList);

    /**
     * 分页查询黑名单核实列表
     *
     * @param page     页
     * @param pageSize 每页条数
     * @param type     类型：0新增黑名单，1已移除->本次为黑，2已加入->本次为灰
     * @return
     */
    PageInfo<BlacklistVerifyVO> findBlackListVerifyPage(int page, int pageSize, String type);


    int getExportTotal(String username, String province,
                       String city, String area,
                       String industry, String riskLevel,
                       Integer start, Integer size,
                       String order, String descAsc);
}
