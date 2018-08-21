package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.PhysicalExaminationAndCheckMapper;
import com.dyhc.hospitalmanager.service.PhysicalExaminationAndCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhysicalExaminationAndCheckServiceImpl implements PhysicalExaminationAndCheckService {

    @Autowired
    private PhysicalExaminationAndCheckMapper physicalExaminationAndCheckMapper;
}
