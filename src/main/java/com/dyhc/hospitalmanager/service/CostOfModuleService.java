package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.CostDetail;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface CostOfModuleService {

    /**
     * 根据Id查询人员信息
     * @param personId
     * @return
     */
    PersonInfo getPersonInfoByPersonInfoId(Integer personId,Integer physicalStatu);

    /**
     * 新增费用信息
     * @param personId
     * @param aggregate
     * @param physicalStatu
     * @return
     */
    Integer addCost(Integer personId, BigDecimal aggregate, Integer physicalStatu);

    /**
     * 新增费用明细信息
     * @param costDetail
     * @return
     */
    Integer addCostDetail(CostDetail costDetail);

    /**
     * 根据人员id查询该体检人是否已缴费/是否已退费
     * @param personId
     * @return
     */
    String getCostTypeByPersonId(Integer personId,String costType);

}
