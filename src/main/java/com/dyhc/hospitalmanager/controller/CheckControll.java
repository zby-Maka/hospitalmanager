package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckControll{

    @Autowired
    private CheckService checkService;
}
