package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.Section;
import com.dyhc.hospitalmanager.service.SectionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SectionWeiController {
    @Resource
    private SectionService sectionService;
    @RequestMapping(value = "addkeshiweihu.do")
    @ResponseBody
    public  String getaddkeshiweihuId(@RequestParam("sectionId")Integer sectionId){
        Section section=sectionService.getSectionsectionId(sectionId);
        System.out.println(section.getRemark());
        return JSON.toJSONString(section);
    }
    @RequestMapping(value = "keshiweihu.do")
    @ResponseBody
    public String insertSectionWei(Section section){
        int result=0;
        String data="";
        if (section.getSectionId()==null){
            result=sectionService.addSectionInfo(section);
        }else {
            result=sectionService.updSectionInfo(section);
        }
        if (result>0){
            data="{\"status\":1}";
        }else {
            data="{\"status\":0}";
        }
        return data;
    }
}
