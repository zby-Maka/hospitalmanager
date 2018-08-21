package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CostMapper;
import com.dyhc.hospitalmanager.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostServiceImpl implements CostService {

    @Autowired
    private CostMapper costMapper;
}
