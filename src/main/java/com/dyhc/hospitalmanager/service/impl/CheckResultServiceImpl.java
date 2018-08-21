package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CheckResultMapper;
import com.dyhc.hospitalmanager.service.CheckResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckResultServiceImpl implements CheckResultService {

    @Autowired
    private CheckResultMapper checkResultMapper;
}
