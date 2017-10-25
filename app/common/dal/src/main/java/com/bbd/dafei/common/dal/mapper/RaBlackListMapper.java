package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.dal.po.RaBlacklistPO;
import com.bbd.dafei.common.modal.dto.BlacklistAddDTO;
import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.vo.*;
import com.bbd.dafei.common.util.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017-04-20.
 */
public interface RaBlackListMapper {


    List<RaBlackListVO> getDataForExcel(@Param("province") String privince, @Param("city") String city, @Param("area") String area, @Param("industry") String industry);

    List<RaBlackListFocusVO> getDataForPersonExcel(@Param("province") String province, @Param("username") String username);

    int count(@Param("username") String username,
              @Param("province") String province,
              @Param("city") String city,
              @Param("area") String area,
              @Param("industry") String industry,
              @Param("riskLevel") String riskLevel,
              @Param("status") Integer status);

    List<RaBlackListVO> query(@Param("username") String username,
                              @Param("province") String province,
                              @Param("city") String city,
                              @Param("area") String area,
                              @Param("industry") String industry,
                              @Param("riskLevel") String riskLevel,
                              @Param("status") Integer status,
                              @Param("start") Integer start,
                              @Param("size") Integer size,
                              @Param("order") String order,
                              @Param("descAsc") String descAsc);


    int countAddAndCancel(@Param("username") String username,
                          @Param("province") String province,
                          @Param("city") String city,
                          @Param("area") String area,
                          @Param("industry") String industry,
                          @Param("riskLevel") String riskLevel,
                          @Param("status") Integer status);

    List<RaBlackListVO> queryAddAndCancel(@Param("username") String username,
                                          @Param("province") String province,
                                          @Param("city") String city,
                                          @Param("area") String area,
                                          @Param("industry") String industry,
                                          @Param("riskLevel") String riskLevel,
                                          @Param("status") Integer status,
                                          @Param("start") Integer start,
                                          @Param("size") Integer size,
                                          @Param("order") String order,
                                          @Param("descAsc") String descAsc);


    /**
     * 根据企业名查询企业的最新黑名单信息
     *
     * @param companyId
     * @return
     */
    RaBlacklistPO findLastBlackByCompanyId(String companyId);

    /**
     * 通过id查询黑名单
     *
     * @param id
     * @return
     */
    RaBlacklistPO findBlacklistById(Integer id);

    /**
     * 批量根据id查询黑名单
     *
     * @param ids
     * @return
     */
    List<RaBlacklistPO> findBlacklistsByIds(@Param("ids") List<Integer> ids);

    /**
     * 根据黑名单id查询拉黑原因
     *
     * @param blackId
     * @return
     */
    List<String> findBlackReasonsByBlackId(Integer blackId);

    void cancelBlack(@Param("id") Integer id,
                     @Param("companyId") String companyId,
                     @Param("cancelReason") List<KeyValDTO<Integer, String>> cancelReason,
                     @Param("cancelUser") String cancelUser,
                     @Param("cancelDate") Date cancelDate,
                     @Param("cancelByUser") boolean cancelByUser);

    /**
     * 根据公司id批量查询在黑名单中的公司
     *
     * @param companyIds
     * @return
     */
    List<String> findBlackListByCompanyIds(@Param("companyIds") Set<String> companyIds);

    int inBlacklist(String companyId);

    void addBlacklist(BlacklistAddDTO vo);

    /**
     * 修改黑名单
     *
     * @param id       黑名单id
     * @param username 加入用户
     * @param joinDate 加入时间
     */
    void updateBlacklist(@Param("id") Integer id, @Param("username") String username, @Param("joinDate") Date joinDate);

    void addBlacklistReasons(@Param("companyId") String companyId,
                             @Param("blacklistId") Integer blacklistId,
                             @Param("gmtCreate") Date gmtCreate,
                             @Param("reasons") List<KeyValDTO<Integer, String>> addReasons);


    void lookOverCancel(@Param("addUser") String addUser, @Param("id") Integer id);


    /**
     * 根据企业ID统计是否在黑名单列表内
     * 用户添加的移出了也算存在，不能再重复添加
     */
    int isexist(@Param("companyId") String companyId);

    /**
     * 根据企业ID 用户名查看是否存在黑名单列表里
     *
     * @param companyId
     * @return
     */
    int findDataByAddUserAndCompanyIdForPersonalCenter(@Param("companyId") String companyId);

    Integer findBlackListByCompanyId(@Param("companyId") String companyId);

    WrodBlackListInfoVO getBlackListInfoByCompanyId(@Param("companyId") String companyId);

    List<BlacklistVO> queryAndReasonPage(@Param("map") Map<String, Object> map);

    List<BlacklistVO> queryAndReasonByIds(@Param("ids") List<Integer> ids, @Param("order") String order, @Param("ascDesc") String ascDesc);

    /**
     * 根据id删除黑名单
     *
     * @param id
     */
    void deleteBlacklistById(Integer id);

    /**
     * 根据id批量删除黑名单
     *
     * @param ids
     */
    void deleteBlacklistByIds(@Param("ids") List<Integer> ids);

    /**
     * 根据id删除
     *
     * @param blackId
     */
    void deleteBlackReasonByBlackId(Integer blackId);

    /**
     * 根据id批量删除
     *
     * @param blackIds
     */
    void deleteBlackReasonsByBlackIds(@Param("blackIds") List<Integer> blackIds);

    /**
     * 查询所黑名单
     *
     * @return
     */
    List<BlacklistVO> findAllBlackList();

    /**
     * 查询所有非用户添加的黑名单
     *
     * @return
     */
    List<BlacklistVO> findAllManagedBlackList();

    /**
     * 分页查询黑名单核实列表
     *
     * @param pageInfo
     * @return
     */
    List<BlacklistVerifyVO> findBlackListVerifyPage(@Param("page") PageInfo pageInfo, @Param("type") String type);

    /**
     * 取得所有黑名单
     * @return
     */
    List<RaBlacklistPO> findAll();

    /**
     * 更新黑名单中省市区与企业表一致
     */
    void updateProvinceCityArea();
}
