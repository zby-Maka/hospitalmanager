package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.MedicalEventsMapper;
import com.dyhc.hospitalmanager.service.MedicalEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalEventsServiceImpl implements MedicalEventsService {

    @Autowired
    private MedicalEventsMapper medicalEventsMapper;
}
