package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CombinationAndCheckMapper;
import com.dyhc.hospitalmanager.service.CombinationAndCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CombinationAndCheckServiceImpl implements CombinationAndCheckService {

    @Autowired
    private CombinationAndCheckMapper combinationAndCheckMapper;
}
