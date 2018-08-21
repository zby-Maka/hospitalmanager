package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CostDetailMapper;
import com.dyhc.hospitalmanager.service.CostDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostDetailServiceImpl implements CostDetailService {

    @Autowired
    private CostDetailMapper costDetailMapper;
}
