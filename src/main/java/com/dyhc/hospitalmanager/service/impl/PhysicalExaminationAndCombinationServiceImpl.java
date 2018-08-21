package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.PhysicalExaminationAndCombinationMapper;
import com.dyhc.hospitalmanager.service.PhysicalExaminationAndCombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhysicalExaminationAndCombinationServiceImpl implements PhysicalExaminationAndCombinationService {

    @Autowired
    private PhysicalExaminationAndCombinationMapper physicalExaminationAndCombinationMapper;
}
