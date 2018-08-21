package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.CostDetail;
import org.apache.ibatis.annotations.Param;

public interface CostDetailMapper {

    /**
     * 添加费用明细表
     * @param costDetail
     * @return
     */
    Integer addCostDetail(@Param("costDetail")CostDetail costDetail)throws Exception;

}
