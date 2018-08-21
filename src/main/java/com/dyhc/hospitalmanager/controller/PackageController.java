package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageController{

    @Autowired
    private PackageService packageService;
}
