package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.CompanyInfo;
import com.dyhc.hospitalmanager.service.UnitReservationService;
import com.dyhc.hospitalmanager.service.impl.ExcelServiceImpl;
import com.dyhc.hospitalmanager.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;

/**
 * 单位预约
 */
@Controller
public class UnitReservationController {
    @Autowired
    private UnitReservationService unitReservationService;
    @Autowired
    private ExcelServiceImpl excelService;

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

    /**
     * 用户下载Excel模板
     * @return
     * @throws IOException
     */
    @RequestMapping("/admin/model")
    public ResponseEntity<byte[]> download2() throws IOException {
        File file = excelService.buildXlsById();
        return ResponseUtils.buildResponseEntity(file);
    }

    /**
     * 公司对信息进行修改
     * @param companyInfo
     * @return
     */
    @RequestMapping("/updCompanyInfo.do")
    @ResponseBody
    public String updCompanyInfo(CompanyInfo companyInfo){
        Integer content = 0;
        Integer result = unitReservationService.updCompanyInfo(companyInfo);
        if(result > 0){
            content = 1;
        }
        return JSON.toJSONString(content);
    }

    /**
     * 添加信息
     * @param companyInfo
     * @return
     */
    @RequestMapping("/addCompanyInfo.do")
    @ResponseBody
    public String addCompanyInfo(CompanyInfo companyInfo){
        Integer content = 0;
        Integer result = unitReservationService.addCompanyInfo(companyInfo);
        if(result > 0){
            content = 2;
        }
        return JSON.toJSONString(content);
    }

}
