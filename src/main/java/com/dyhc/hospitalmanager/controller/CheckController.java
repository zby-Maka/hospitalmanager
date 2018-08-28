package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.Check;
import com.dyhc.hospitalmanager.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckController{
    @Autowired
    private CheckService checkService;

    @RequestMapping(value = "checkList.do")
    public String getAllCheckList(String physicalExaminationId) {
        List<Check> checkList=checkService.getCheckList(physicalExaminationId);
        String json= JSON.toJSONString(checkList);
        System.out.println(json);
        return json;
    }
}