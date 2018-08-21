package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectionControll {

    @Autowired
    private SectionService sectionService;
}
