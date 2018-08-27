package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonInfoController {
    @Autowired
    private PersonInfoService personInfoService;
    @RequestMapping(value = "personInfo.do")
    public String getpersonInfo(String physicalexaminationid){
        List<PersonInfo> personInfoList=personInfoService.getPersonBypeacId(physicalexaminationid);
        String json=JSON.toJSONString(personInfoList);
        System.out.println(json);
        return json;
    }
}
