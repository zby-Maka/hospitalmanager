package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.service.CostOfModuleService;
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
     * 根据人员Id查询人员信息
     * @param personId
     * @param physicalStatu
     * @return
     */
    @RequestMapping("getPersonInfoByPersonId.do")
    @ResponseBody
    public Object getPersonInfoByPersonId(Integer personId,Integer physicalStatu){
        PersonInfo personInfo = costOfModuleService.getPersonInfoByPersonInfoId(personId,physicalStatu);
        String json = JSON.toJSONString(personInfo);
        return json;
    }

    /**
     * 收费/退费
     * @param personId
     * @param aggregate
     * @param physicalStatu
     * @return
     */
    @RequestMapping("operationCost.do")
    @ResponseBody
    public Object operationCost(Integer personId, String aggregate, Integer physicalStatu){
        String json = JSON.toJSONString(costOfModuleService.addCost(personId,new BigDecimal(aggregate),physicalStatu));
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

}
