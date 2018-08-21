package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.SectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectionTypeControll{

    @Autowired
    private SectionTypeService sectionTypeService;
}
