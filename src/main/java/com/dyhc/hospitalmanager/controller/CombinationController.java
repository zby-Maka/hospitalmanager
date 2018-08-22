package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.pojo.Combination;
import com.dyhc.hospitalmanager.service.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CombinationController {

    @Autowired
    private CombinationService combinationService;

    @GetMapping("/getAllCombinationList")
    public List<Combination> getAllCombinationList() {
        return combinationService.getAllCombinationList();
    }
}
