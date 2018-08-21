package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CommonResultsMapper;
import com.dyhc.hospitalmanager.service.CommonResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonResultsServiceImpl implements CommonResultsService {

    @Autowired
    private CommonResultsMapper commonResultsMapper;
}
