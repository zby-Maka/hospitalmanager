package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Cost;
import org.apache.ibatis.annotations.Param;

public interface CostMapper {

    /**
     * 添加费用表
     * @param cost
     * @return
     */
    Integer addCost(@Param("cost")Cost cost)throws Exception;

}
