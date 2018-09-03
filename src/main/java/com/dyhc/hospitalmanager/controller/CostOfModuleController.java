package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.service.CostOfModuleService;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CostOfModuleController {

    @Autowired
    private CostOfModuleService costOfModuleService;

    /**
     * 根据体检编号查询人员信息及其体检信息
     * @param
     * @param physicalStatu
     * @return
     */
    @RequestMapping("getPersonInfoByPersonId.do")
    @ResponseBody
    public Object getPersonInfoByPersonId(String physical_examination_id,Integer physicalStatu){
        PersonInfo personInfo = costOfModuleService.getPersonInfoByPersonInfoId(physical_examination_id,physicalStatu);
        String json = JSON.toJSONString(personInfo);
        return json;
    }

    /**
     * 收费/退费
     * @param physical_examination_id
     * @param aggregate
     * @param physicalStatu
     * @return
     */
    @RequestMapping("operationCost.do")
    @ResponseBody
    public Object operationCost(String physical_examination_id, String aggregate, Integer physicalStatu){
        String json = JSON.toJSONString(costOfModuleService.addCost(physical_examination_id,new BigDecimal(aggregate),physicalStatu));
        return json;
    }

    /**
     * 根据人员id判断是否已收费/退费
     * @param personId
     * @param costType
     * @return
     */
    @RequestMapping("getCostTypeByPersonId.do")
    @ResponseBody
    public Object getCostTypeByPersonId(Integer personId,String costType){
        String str = costOfModuleService.getCostTypeByPersonId(personId,costType);
        String json = JSON.toJSONString(str);
        return json;
    }

    @RequestMapping("getNumber.do")
    @ResponseBody
    public Object getNumber(String physical_examination_id){
        String json = JSON.toJSONString(costOfModuleService.getCostIdByPhysical_Examination_IdAndCostType(physical_examination_id));
        return json;
    }

}
