package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.PackageAndCombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageAndCombinationController {

    @Autowired
    private PackageAndCombinationService packageAndCombinationService;
}
