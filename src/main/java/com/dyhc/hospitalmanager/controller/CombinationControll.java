package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CombinationControll {

    @Autowired
    private CombinationService combinationService;
}
