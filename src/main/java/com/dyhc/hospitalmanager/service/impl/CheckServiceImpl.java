package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CheckMapper;
import com.dyhc.hospitalmanager.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckMapper CheckMapper;
}
