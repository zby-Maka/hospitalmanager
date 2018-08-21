package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.PhysicalExaminationAndCombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PhysicalExaminationAndCombinationControll{

    @Autowired
    private PhysicalExaminationAndCombinationService physicalExaminationAndCombinationService;
}
