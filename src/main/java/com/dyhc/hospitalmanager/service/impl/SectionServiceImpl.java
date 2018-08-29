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
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Autowired
    private  SectionMapper sectionMapper;


    @Override
    public  Map<String,Object> getPersonCheckBySectionId(String peacId, Integer sectionId){
        Map<String,Object> maplist=null;
        try {
            maplist=new HashMap<>();
            List<Check> map=checkMapper.getPersonCheckBySectionId(peacId,sectionId);
            List<PersonInfo> map1=personInfoMapper.getPersonBypeacId(peacId);
            maplist.put("map",map);
            maplist.put("map1",map1);
        }catch (Exception e){
            logger.error("您的查询有误");
            e.printStackTrace();

        }
        return maplist;
    }

    @Override
    public List<CommonResults> getCommResultsByCheckId(Integer checkId,Integer sectionId) {
        List<CommonResults> list=null;
        try {
            SectionType sectionType=sectionTypeMapper.getSectionTypeName(sectionId);
            if(sectionType.getSectionTypeName().equals("检查")) {
                list = commonResultsMapper.getCommResultsByCheckId(checkId);
            }
        }catch (Exception e){
            logger.error("您的查询有误");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ProposedDescription> getProposedByResultId(Integer resultId,Integer sectionId) {
        List<ProposedDescription> list=null;
        try {
            SectionType sectionType=sectionTypeMapper.getSectionTypeName(sectionId);
            if(sectionType.getSectionTypeName().equals("检查")) {
                list = proposedDescriptionMapper.getProposedByResultId(resultId);
            }
        }catch (Exception e){
            logger.error("您的查询有误");
            e.printStackTrace();
        }
        return list;
    }

//    @Override
//    public Map<String,Object> getCheckResultAndProposed(Integer checkId, Integer resultId,Integer sectionId){
//        Map<String,Object> map=null;
//        try {
//            SectionType sectionType=sectionTypeMapper.getSectionTypeName(sectionId);
//            if(sectionType.getSectionTypeName().equals("检查")){
//                map=new HashMap<>();
//                List<CommonResults> list=commonResultsMapper.getCommResultsByCheckId(checkId);
//                List<ProposedDescription> list1=proposedDescriptionMapper.getProposedByResultId(resultId);
//                map.put("list",list);
//                map.put("list1",list1);
//            }
//        }catch (Exception e){
//            logger.error("您的查询有误");
//            e.printStackTrace();
//        }
//        return map;
//    }




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
                ok=2;
            }else{
                ok=1;
            }
        }catch (Exception e){
            logger.error("增加出错了");
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public int addSectionInfo(Section section) {
        int result=0;
        try {
            result=sectionMapper.addSectionInfo(section);
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }


}
