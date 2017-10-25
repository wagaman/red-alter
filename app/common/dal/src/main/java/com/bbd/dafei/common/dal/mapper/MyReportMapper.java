package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.modal.vo.MyReportListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tuanhong on 2017-04-24.
 */
public interface MyReportMapper {

   int count(@Param("userId") int userId);

   List<MyReportListVO> query(@Param("userId") int userId,
                               @Param("start")    Integer start,
                               @Param("size")     Integer size);

   int queryCount(@Param("userId") int userId,@Param("reportStatus") String reportStatus);

   String getApplyTime(@Param("userId") int userId,@Param("companyId") String companyId ,@Param("reportStatus") String reportStatus);

   String getMaxApplyTime(@Param("userId") int userId,@Param("companyId") String company ,@Param("reportStatus") String reportStatus);
}
