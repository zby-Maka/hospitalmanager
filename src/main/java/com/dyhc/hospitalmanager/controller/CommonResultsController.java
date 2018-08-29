package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.CommonResults;
import com.dyhc.hospitalmanager.service.CommonResultsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CommonResultsController {
    @Resource
    private CommonResultsService commonResultsService;
    /**
     * 进入添加页面
     */
    @RequestMapping("/addProvideInfo")
    public String addInfo(Model model, Integer commonResultsId) {
        CommonResults commonResults=commonResultsService.getCommonResultsid(commonResultsId);
        model.addAttribute("commonResults", commonResults);
        return "/Thebackend-page/jieguojianyi";
    };

    /**
     * 添加常见结果
     * @param commonResults
     * @return
     */
    @RequestMapping(value = "insertcommonResults.do")
    @ResponseBody
    public  String getinsertcommonResults(CommonResults commonResults){
        int result=commonResultsService.addCommonResultsInfo(commonResults);
        String data="";
        if (result>0){
            data="{\"status\":1}";
        }else {
            data="{\"status\":0}";
        }
        return data;
    }
    /**
     * 修改常见结果
     * @param commonResults
     * @return
             */
    @RequestMapping(value = "updatecommonResults.do")
    @ResponseBody
    public  String getupdatetcommonResults(CommonResults commonResults){
        int result=0;
        String data="";
            result =commonResultsService.updCommonResultsInfo(commonResults);
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
    @RequestMapping(value = "commonresult.do")
    @ResponseBody
    public String getCommonResult(){
        List<CommonResults> commonResultsList=commonResultsService.getCommResultslist();
        String json=JSON.toJSONString(commonResultsList);
        return json;
    }
}
