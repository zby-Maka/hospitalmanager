package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CheckMapper;
import com.dyhc.hospitalmanager.dao.GuideMapper;
import com.dyhc.hospitalmanager.dao.PersonInfoMapper;
import com.dyhc.hospitalmanager.dao.PhysicalExaminationMapper;
import com.dyhc.hospitalmanager.pojo.Check;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.pojo.PhysicalExamination;
import com.dyhc.hospitalmanager.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckMapper CheckMapper;
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Autowired
    private GuideMapper guideMapper;
    @Autowired
    private PhysicalExaminationMapper physicalExaminationMapper;

    @Override
    public List<Check> getAllCheckList() {
        try {
            return CheckMapper.getAllCheckList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Check> getCheckList(String physicalExaminationId) {
        try {
            return CheckMapper.getCheckList(physicalExaminationId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PersonInfo> personInfo(String peacId) {
        try {
            List<PersonInfo> list  = personInfoMapper.getPersonBypeacId(peacId);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Check> showListCheckLwr(String physicalExaminationId) {
        try {
            return guideMapper.showListCheck(physicalExaminationId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PhysicalExamination selectPhysical(String physicalExaminationId) {
        try {
            return physicalExaminationMapper.selectPhysical(physicalExaminationId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
