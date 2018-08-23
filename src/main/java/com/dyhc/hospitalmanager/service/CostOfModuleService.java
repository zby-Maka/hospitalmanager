package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.Cost;
import com.dyhc.hospitalmanager.pojo.CostDetail;
import com.dyhc.hospitalmanager.pojo.PersonInfo;

public interface CostOfModuleService {

    /**
     * crf
     * 根据Id查询人员信息
     * @param personId
     * @return
     */
    PersonInfo getPersonInfoByPersonInfoId(Integer personId,Integer physicalStatu);

    /**
     * crf
     * 新增费用信息
     * @param cost
     * @return
     */
    Integer addCost(Cost cost,Integer physicalStatu);

    /**
     * crf
     * 新增费用明细信息
     * @param costDetail
     * @return
     */
    Integer addCostDetail(CostDetail costDetail);

}
