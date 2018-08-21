package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CostControll {

    @Autowired
    private CostService costService;
}
