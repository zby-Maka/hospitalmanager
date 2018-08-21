package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.CostDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CostDetailController {

    @Autowired
    private CostDetailService costDetailService;
}
