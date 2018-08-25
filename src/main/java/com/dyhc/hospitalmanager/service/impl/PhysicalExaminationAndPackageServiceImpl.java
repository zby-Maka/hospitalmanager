package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.PhysicalExaminationAndPackageMapper;
import com.dyhc.hospitalmanager.service.PhysicalExaminationAndPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhysicalExaminationAndPackageServiceImpl implements PhysicalExaminationAndPackageService {

    @Autowired
    private PhysicalExaminationAndPackageMapper physicalExaminationAndPackageMapper;


}
