package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Combination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CombinationAndCheckMapper {
    /**王娇
     * 根据体检编号查询人员在该科室下的体检项，组合项
     * @param checkId
     * @return
     */
    Combination getCheckAndComByCheckId(@Param("checkId")Integer checkId);
}
