package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArchivesControll{

    @Autowired
    private ArchivesService archivesService;
}
