package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.PhysicalExaminationAndCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhysicalExaminationAndCheckController{

    @Autowired
    private PhysicalExaminationAndCheckService physicalExaminationAndCheckService;
}
