package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.pojo.Check;
import com.dyhc.hospitalmanager.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckController{

    @Autowired
    private CheckService checkService;

    @GetMapping("/getAllCheckList")
    public List<Check> getAllCheckList() {
        return checkService.getAllCheckList();
    }
}