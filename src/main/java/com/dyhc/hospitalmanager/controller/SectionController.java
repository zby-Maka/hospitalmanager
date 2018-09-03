package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dyhc.hospitalmanager.pojo.CheckResult;
import com.dyhc.hospitalmanager.pojo.CommonResults;
import com.dyhc.hospitalmanager.pojo.MedicalEvents;
import com.dyhc.hospitalmanager.pojo.ProposedDescription;
import com.dyhc.hospitalmanager.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
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
    public String getPersonCheckBySectionId(@RequestParam("peacId") String peacId, HttpServletRequest request) {
        HttpSession session=request.getSession();
        Integer sectionId=(Integer) session.getAttribute("sectionId");
        Map<String,Object> map = sectionService.getPersonCheckBySectionId(peacId,sectionId);
        return JSON.toJSONString(map);
    }

    //检查:结果
    @RequestMapping("getCommResultsByCheckId.html")
    @ResponseBody
    public String getCommResultsByCheckId(@RequestParam("checkId")Integer checkId,HttpServletRequest request){
        HttpSession session=request.getSession();
        Integer sectionId=(Integer) session.getAttribute("sectionId");
        List<CommonResults> list=sectionService.getCommResultsByCheckId(checkId,sectionId);
        return JSON.toJSONString(list);
    }
    //检查:建议
    @RequestMapping("getProposedByResultId.html")
    @ResponseBody
    public String getProposedByResultId(@RequestParam("resultId")Integer resultId,HttpServletRequest request){
        HttpSession session=request.getSession();
        Integer sectionId=(Integer) session.getAttribute("sectionId");
        List<ProposedDescription> list=sectionService.getProposedByResultId(resultId,sectionId);
        return JSON.toJSONString(list);
    }
    @RequestMapping("/getYan.html")
    @ResponseBody
    public String getYan(@RequestParam("checkId")Integer checkId){
        HttpClient httpClient=new HttpClient();
        String content = httpClient.httpGet("http://ourmodel.xin/demo-0.0.1-SNAPSHOT/selEventsByCheckId?checkId="+checkId);
        return content;
    }

    //CheckResult checkResult,
    //检查增加体检结果，检验增加体检结果和检验明细
    @RequestMapping("addResultAndMedicalEvent.html")
    @ResponseBody
    public String addResultAndMedicalEvent(@RequestBody JSONObject params, HttpServletRequest request){
        HttpSession session=request.getSession();
        CheckResult checkResult= params.getObject("checkResult",CheckResult.class);
        Integer sectionId=(Integer) session.getAttribute("sectionId");
        List<MedicalEvents> medicalEvents = null;
        if(params.getJSONArray("medicalEventsList")!=null){
            JSONArray jsonArray =params.getJSONArray("medicalEventsList");
            String arrJSON = JSON.toJSONString(jsonArray);
            medicalEvents = JSONArray.parseArray(arrJSON,MedicalEvents.class);
        }
        Integer add=sectionService.addCheckResultAndMedicalEvent(checkResult,medicalEvents,sectionId);
        String json="";
        System.out.println(add);
        if(add>0){
            json="{\"stat\":\"ok\"}" ;
        }else{
            json="{\"stat\":\"no\"}";
        }
        return json;
    }
    @RequestMapping("/update.html")
    @ResponseBody
    public String updateStatu(@RequestParam("peaId")String peaId,@RequestParam("checkId")Integer checkId){
        Integer update=sectionService.updateStatu(peaId,checkId);
         return  JSON.toJSONString(update);
    }
}
