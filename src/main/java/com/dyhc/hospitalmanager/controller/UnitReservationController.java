package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.CompanyInfo;
import com.dyhc.hospitalmanager.service.UnitReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 单位预约
 */
@Controller
public class UnitReservationController {
    @Autowired
    private UnitReservationService unitReservationService;

    /**
     * 根据公司名称查询是否有公司信息
     * @param companyName 公司名称
     * @return
     */
    @RequestMapping("showCompanyInfo.do")
    @ResponseBody
    public String showCompanyInfo(@RequestParam("companyName") String companyName){
        CompanyInfo companyInfo = unitReservationService.showCompanyInfo(companyName);
        return JSON.toJSONString(companyInfo);
    }

}
