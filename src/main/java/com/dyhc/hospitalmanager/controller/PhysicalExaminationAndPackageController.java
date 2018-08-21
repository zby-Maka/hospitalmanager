package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.PhysicalExaminationAndPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhysicalExaminationAndPackageController {

    @Autowired
    private PhysicalExaminationAndPackageService physicalExaminationAndPackageService;
}
