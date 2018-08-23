package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.*;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.service.SectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public List<CommonResults> getCommResultsByCheckId(Integer checkId) throws Exception {
        List<CommonResults> list=null;
        try {
            list=commonResultsMapper.getCommResultsByCheckId(checkId);
        }catch (Exception e){
            logger.error("您的查询有误");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ProposedDescription> getProposedByResultId(Integer resultId) throws Exception {
        List<ProposedDescription> list=null;
        try {
            list=proposedDescriptionMapper.getProposedByResultId(resultId);
        }catch (Exception e){
            logger.error("您的查询有误");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Integer addCheckResult(CheckResult checkResult) throws Exception {
        Integer save=0;
        Integer ok=0;
        try {
            save=checkResultMapper.addCheckResult(checkResult);
            if(save>0){
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

    @Override
    public Integer addMedicalEvent(CheckResult checkResult,MedicalEvents medicalEvents) throws Exception {
        Integer save=0;
        Integer add=0;
        Integer ok=0;
        try {
            add=checkResultMapper.addCheckResult(checkResult);
            save=medicalEventsMapper.addMedicalEvent(medicalEvents);
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
