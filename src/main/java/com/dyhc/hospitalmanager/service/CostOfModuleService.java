package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.CostDetail;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface CostOfModuleService {

    /**
     * 根据体检编号查询人员信息及其体检信息
     * @param physical_examination_id
     * @return
     */
    PersonInfo getPersonInfoByPersonInfoId(String physical_examination_id,Integer physicalStatu);

    /**
     * 新增费用信息
     * @param physical_examination_id
     * @param aggregate
     * @param physicalStatu
     * @return
     */
    Integer addCost(String physical_examination_id, BigDecimal aggregate, Integer physicalStatu);

    /**
     * 新增费用明细信息
     * @param costDetail
     * @return
     */
    Integer addCostDetail(CostDetail costDetail);

    /**
     * 根据人员id查询该体检人是否已缴费/是否已退费
     * @param physical_examination_id
     * @return
     */
    String getCostTypeByPersonId(String physical_examination_id,String costType);

    /**
     * 根据体检编号与费用类型判断该用户是否已进行缴费
     * @return
     */
    Integer getCostIdByPhysical_Examination_IdAndCostType(String physical_examination_id);

}
