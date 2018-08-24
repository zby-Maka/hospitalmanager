package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.*;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.service.SectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("SectionService")
public class SectionServiceImpl implements SectionService {
    private Logger logger= LoggerFactory.getLogger(SectionService.class);
    @Autowired
    private CheckMapper checkMapper;
    @Autowired
    private CheckResultMapper checkResultMapper;
    @Autowired
    private MedicalEventsMapper medicalEventsMapper;
    @Autowired
    private CommonResultsMapper commonResultsMapper;
    @Autowired
    private ProposedDescriptionMapper proposedDescriptionMapper;
    @Autowired
    private SectionTypeMapper sectionTypeMapper;


    @Override
    public List<Check> getPersonCheckBySectionId(String peacId, Integer sectionId) throws Exception {
        List<Check> list=null;
        try {
            list=checkMapper.getPersonCheckBySectionId(peacId,sectionId);
        }catch (Exception e){
            logger.error("您的查询有误");
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public Map<String,Object> getCheckResultAndProposed(Integer checkId, Integer resultId,Integer sectionId) throws Exception {
        Map<String,Object> map=null;
        try {
            SectionType sectionType=sectionTypeMapper.getSectionTypeName(sectionId);
            if(sectionType.getSectionTypeName()=="检查"){
                map=new HashMap<>();
                List<CommonResults> list=commonResultsMapper.getCommResultsByCheckId(checkId);
                List<ProposedDescription> list1=proposedDescriptionMapper.getProposedByResultId(resultId);
                map.put("list",list);
                map.put("list1",list1);
            }
        }catch (Exception e){
            logger.error("您的查询有误");
            e.printStackTrace();
        }
        return map;
    }




    @Override
    public Integer addCheckResultAndMedicalEvent(CheckResult checkResult,MedicalEvents medicalEvents,Integer sectionId) {
        Integer save=0;
        Integer add=0;
        Integer ok=0;
        try {
            SectionType sectionType=sectionTypeMapper.getSectionTypeName(sectionId);
            System.out.println(sectionType.getSectionTypeName());
            if(sectionType.getSectionTypeName().equals("检查")){
                save=checkResultMapper.addCheckResult(checkResult);
            }else if(sectionType.getSectionTypeName().equals("检验")){
                save=checkResultMapper.addCheckResult(checkResult);
                add=medicalEventsMapper.addMedicalEvent(medicalEvents);
            }else{
                save=checkResultMapper.addCheckResult(checkResult);
            }
            if(add>0&&save>0){
                ok=1;
            }else{
                ok=0;
            }
        }catch (Exception e){
            logger.error("增加出错了");
            e.printStackTrace();
        }
        return ok;
    }






}
