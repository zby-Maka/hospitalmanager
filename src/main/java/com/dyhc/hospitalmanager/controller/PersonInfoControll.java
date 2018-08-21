package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonInfoControll {

    @Autowired
    private PersonInfoService personInfoService;
}
