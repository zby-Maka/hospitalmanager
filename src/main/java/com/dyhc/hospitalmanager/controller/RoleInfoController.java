package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleInfoController{

    @Autowired
    private RoleInfoService roleInfoService;
}
