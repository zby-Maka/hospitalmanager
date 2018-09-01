package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.ProposedDescription;
import com.dyhc.hospitalmanager.service.ProposedDesriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ProposedDesriptionController {
    @Resource
    private ProposedDesriptionService proposedDesriptionService;

    /**
     * 进入添加页面
     */
    @RequestMapping("/addProposedDescription.do")
    @ResponseBody
    public String addInfo(@RequestParam("proposedDescriptionId") Integer proposedDescriptionId) {
        ProposedDescription proposedDescription=proposedDesriptionService.getProposedDescriptionByid(proposedDescriptionId);
        return JSON.toJSONString(proposedDescription);
    };

    /**
     * 添加,修改常见结果
     * @param proposedDescription
     * @return
     */
    @RequestMapping(value = "insertProposedDescription.do")
    @ResponseBody
    public  String getinsertProposedDescription(ProposedDescription proposedDescription){
        int result=0;
        String data="";
        if(proposedDescription.getProposedDescriptionId()==null){
            result=proposedDesriptionService.addProposedDescriptionInfo(proposedDescription);
        }else {
            result=proposedDesriptionService.updProposedDescriptionInfo(proposedDescription);
        }
        if (result>0){
            data="{\"status\":1}";
        }else {
            data="{\"status\":0}";
        }
        return data;
    }
    /**
     * 查询常见结果
     */
    @RequestMapping(value = "proposedDescription.do")
    @ResponseBody
    public String getProposedDescription(){
        List<ProposedDescription> proposedDescriptionList=proposedDesriptionService.getProposedDescriptionlist();
        String json=JSON.toJSONString(proposedDescriptionList);
        return json;
    }

}
