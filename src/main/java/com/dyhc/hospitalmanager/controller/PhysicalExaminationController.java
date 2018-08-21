package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.PhysicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhysicalExaminationController{

    @Autowired
    private PhysicalExaminationService physicalExaminationService;
}