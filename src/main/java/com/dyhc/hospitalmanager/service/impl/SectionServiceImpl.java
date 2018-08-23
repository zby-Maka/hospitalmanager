package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.SectionMapper;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SectionService")
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionMapper sectionMapper;

    @Override
    public List<Check> getPersonCheckBySectionId(String peacId, Integer sectionId) throws Exception {
        return null;
    }

    @Override
    public Integer addCheckResult(CheckResult checkResult) throws Exception {
        return null;
    }

    @Override
    public List<CommonResults> getCommResultsByCheckId(Integer checkId) throws Exception {
        return null;
    }

    @Override
    public Integer addMedicalEvent(MedicalEvents medicalEvents) throws Exception {
        return null;
    }

    @Override
    public List<ProposedDescription> getProposedByResultId(Integer resultId) throws Exception {
        return null;
    }
}
