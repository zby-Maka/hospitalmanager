package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupControll {

    @Autowired
    private GroupService groupService;
}
