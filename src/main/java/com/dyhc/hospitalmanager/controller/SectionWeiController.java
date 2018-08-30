package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.pojo.Section;
import com.dyhc.hospitalmanager.service.SectionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SectionWeiController {
    @Resource
    private SectionService sectionService;
    @RequestMapping(value = "keshiweihu.do")
    @ResponseBody
    public String insertSectionWei(Section section){
        int result=sectionService.addSectionInfo(section);
        String data="";
        if (result>0){
            data="{\"status\":1}";
        }else {
            data="{\"status\":0}";
        }
        return data;
    }
}
