package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageController{

    @Autowired
    private PackageService packageService;

    @GetMapping("/getPackage")
    public List<Package> getPackage() {
        return packageService.getPackage();
    }
}
