package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

@Controller
public class SectionController {
    @Autowired
    private SectionService sectionService;

    /**
     * 根据体检编号查询人员
     *  根据体检编号查询人员在该科室下的体检项
     * @param peacId
     * @return
     */

    @RequestMapping("Person.html")
    @ResponseBody
    public String getPersonCheckBySectionId(@RequestParam("peacId") String peacId) {
        Map<String,Object> map = sectionService.getPersonCheckBySectionId(peacId, 1);
        return JSON.toJSONString(map);
    }
    @RequestMapping("ResultAndProposed.html")
    @ResponseBody
    public String getResultAndProposed(@RequestParam("checkId")Integer checkId, @RequestParam("resultId")Integer resultId){
        Map<String,Object> map=sectionService.getCheckResultAndProposed(checkId,resultId,1);
        return JSON.toJSONString(map);
    }




    }
