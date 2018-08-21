package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Check;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CombinationAndCheckMapper {

    /**
     * 根据组合项Id，查询其下的所有体检项
     * @param comId 组合项Id
     * @return
     */
    List<Check> getCheckByCombinationId(@Param("comId")Integer comId);
}
