package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Combination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.dyhc.hospitalmanager.pojo.Check;

public interface CombinationAndCheckMapper {

    /**
     * 根据组合项Id，查询其下的所有体检项
     * @param comId 组合项Id
     * @return
     */
    List<Check> getCheckByCombinationId(@Param("comId")Integer comId)throws  Exception;
    /**王娇
     * 根据体检编号查询人员在该科室下的体检项，组合项
     * @param checkId
     * @return
     */
    Combination getCheckAndComByCheckId(@Param("checkId")Integer checkId)throws Exception;
}
