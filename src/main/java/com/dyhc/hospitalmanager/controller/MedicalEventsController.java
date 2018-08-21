package com.dyhc.hospitalmanager.controller;

import com.dyhc.hospitalmanager.service.MedicalEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalEventsController {

    @Autowired
    private MedicalEventsService medicalEventsService;
}
