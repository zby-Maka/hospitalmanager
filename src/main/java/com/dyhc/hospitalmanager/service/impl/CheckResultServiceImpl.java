package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CheckResultMapper;
import com.dyhc.hospitalmanager.pojo.CheckResult;
import com.dyhc.hospitalmanager.service.CheckResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckResultServiceImpl implements CheckResultService {

    @Autowired
    private CheckResultMapper checkResultMapper;

    @Override
    public List<CheckResult> getCheckResults(String physicalExaminationId) {
        try {
            return checkResultMapper.getCheckResults(physicalExaminationId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
