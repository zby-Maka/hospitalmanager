package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.CheckResult;
import com.dyhc.hospitalmanager.service.CheckResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckResultController {
    @Autowired
    private CheckResultService checkResultService;
    @RequestMapping(value = "checkResults.do")
    public  String getCheckResult(String physicalexaminationid){
        List<CheckResult> checkResultList=checkResultService.getCheckResults(physicalexaminationid);
        String json= JSON.toJSONString(checkResultList);
        return json;
    }

}

