package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.RoleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleTypeController {

    @Autowired
    private RoleTypeService roleTypeService;
}
