package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CombinationMapper;
import com.dyhc.hospitalmanager.service.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CombinationServiceImpl implements CombinationService {

    @Autowired
    private CombinationMapper combinationMapper;
}
