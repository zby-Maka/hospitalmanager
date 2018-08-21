package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.CheckResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckResultControll{

    @Autowired
    private CheckResultService checkResultService;
}
