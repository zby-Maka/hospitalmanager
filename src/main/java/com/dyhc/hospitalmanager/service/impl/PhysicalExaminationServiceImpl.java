package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.PhysicalExaminationMapper;
import com.dyhc.hospitalmanager.service.PhysicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhysicalExaminationServiceImpl implements PhysicalExaminationService {

    @Autowired
    private PhysicalExaminationMapper physicalExaminationMapper;
}
