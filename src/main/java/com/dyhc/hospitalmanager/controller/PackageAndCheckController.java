package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.PackageAndCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageAndCheckController{

    @Autowired
    private PackageAndCheckService packageAndCheckService;
}
