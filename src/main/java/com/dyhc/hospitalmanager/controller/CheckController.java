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

    /**
     * 根据体检编号和手机号查询体检项以及结果
     * @param physicalExaminationId
     * @param telephone
     * @return
     * @throws Exception
     */
    @RequestMapping("/getPersonInfoCheckList.do")
    public Object getChecks(String physicalExaminationId,String telephone) throws Exception {
        List<Check> checkList=checkService.getChecks(physicalExaminationId, telephone);
        String json=JSON.toJSONString(checkList);
        System.out.println(json);
        return json;
    }


    @RequestMapping(value = "checkall.do")
    public String getChecklist(){
        List<Check> checkList=checkService.getAllCheckList();
        String json=JSON.toJSONString(checkList);
        System.out.println(json);
        return json;
    }
}