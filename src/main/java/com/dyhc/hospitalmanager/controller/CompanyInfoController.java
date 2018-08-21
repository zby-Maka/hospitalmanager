package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyInfoController{

    @Autowired
    private CompanyInfoService companyInfoService;
}
