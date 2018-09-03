package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.CommonResults;
import com.dyhc.hospitalmanager.service.CommonResultsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommonResultsController {
    @Resource
    private CommonResultsService commonResultsService;


    /**
     * 进入添加页面
     */
    @RequestMapping("/addProvideInfo")
    @ResponseBody
    public String addInfo(@RequestParam("commonResultsId") Integer commonResultsId) {
        CommonResults commonResults=commonResultsService.getCommonResultsid(commonResultsId);
        return JSON.toJSONString(commonResults);
    };

    /**
     * 添加,修改常见结果
     * @param commonResults
     * @return
     */
    @RequestMapping(value = "insertcommonResults.do")
    @ResponseBody
    public  String getinsertcommonResults(CommonResults commonResults){
        int result=0;
        String data="";
        if(commonResults.getCommonResultsId()==null){
            result=commonResultsService.addCommonResultsInfo(commonResults);
        }else {
            result=commonResultsService.updCommonResultsInfo(commonResults);
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
    @RequestMapping(value = "commonresult.do")
    @ResponseBody
    public String getCommonResult(@RequestParam("checkId") Integer checkId){
        List<CommonResults> commonResultsList=commonResultsService.getCommResultslist(checkId);
        String json=JSON.toJSONString(commonResultsList);
        System.out.println(json);
        return json;
    }
}
