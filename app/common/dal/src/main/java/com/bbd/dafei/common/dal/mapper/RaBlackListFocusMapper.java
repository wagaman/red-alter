package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.dal.po.RaBlackListFocusPO;
import com.bbd.dafei.common.dal.po.RaMyFocusPO;
import com.bbd.dafei.common.modal.dto.BlackWhiteDTO;
import com.bbd.dafei.common.modal.dto.CommonDTO;
import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.vo.RaBlackListFocusVO;
import com.bbd.dafei.common.util.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tuanhong on 2017-04-23.
 */
public interface RaBlackListFocusMapper {


    List<RaBlackListFocusVO> findByUsernameForExport(@Param("username") String username);

    int countFocusByUsername(@Param("username") String username);

    List<RaBlackListFocusVO> queryRiskChange(@Param("username") String username,
                                             @Param("page") PageInfo page);

    int countRiskChange(@Param("username") String username);


    /**
     * 根据公司id查询区域内用户的关注次数
     *
     * @param companyId 企业id
     * @param province  省
     * @return
     */
    int findFocusNumByCompanyIdAndProvince(@Param("companyId") String companyId, @Param("province") String province);

    /**
     * 查询某用户对公司的最新关注信息
     *
     * @param companyId 企业id
     * @param userName  用户名
     * @return
     */
    RaMyFocusPO findLastedFocusByCompanyIdAndUserName(@Param("companyId") String companyId, @Param("userName") String userName);

    /**
     * 保存拉黑、关注、备注信息
     *
     * @param raBlackListFocusPO
     */
    void insertRaBlackListFocus(RaBlackListFocusPO raBlackListFocusPO);

    /**
     * 根据id查询拉黑、关注、备注信息
     *
     * @param id
     * @return
     */
    RaBlackListFocusPO findRaBlackListFocusById(String id);

    /**
     * 修改关注企业的查看状态
     *
     * @param id       不传id表示修改全部
     * @param lookOver 查看状态
     * @return void
     */
    void updateLookOver(@Param("id") Integer id,
                        @Param("lookOver") int lookOver);

    int countMyFocus(@Param("type") int type,
                     @Param("username") String username,
                     @Param("industry") String industry,
                     @Param("riskLevel") String riskLevel);

    List<RaBlackListFocusVO> queryMyFocus(@Param("page") PageInfo page,
                                          @Param("type") int type,
                                          @Param("username") String username,
                                          @Param("industry") String industry,
                                          @Param("riskLevel") String riskLevel,
                                          @Param("order") String order,
                                          @Param("descAsc") String descAsc);

    void cancelFocus(@Param("id") Integer id,@Param("blackChangeLook") Integer blackChangeLook);


    int countBlackByUserId(@Param("username") String username);

    int isFocusByUser(@Param("username") String username,
                      @Param("companyId") String companyId);

    int addFocus(CommonDTO vo);

    int addFocusReasons(@Param("companyId") String companyId,
                        @Param("focusId") Integer focusId,
                        @Param("reasons") List<KeyValDTO<Integer, String>> reasons);


    List<BlackWhiteDTO> queryBlackWhite(@Param("start") Integer start,
                                        @Param("size") Integer size);





    /**
     *
     * 统计blackWhite数量
     * @return void
     */
    int countBlackWhite();


    /**
     *
     * 根据黑名单表来删除高危企业
     * @return void
     */
    void deleteHighCompanyByBlacklist();


    List<Integer> queryFocusByCompanyId(@Param("companyId") String companyId);


    /**
     * 查看被加入黑名单而取消关注的企业的状态
     * @param id 关注ID
     * */
    void lookBlackChangeCancelFoucs(@Param("id")Integer id);


    /**
     * 根据黑名单列表取消关注
     * @return void
     * */
    void blacklistCancelFocus();
}
