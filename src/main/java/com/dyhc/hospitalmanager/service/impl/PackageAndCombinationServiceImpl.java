package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.PackageAndCombinationMapper;
import com.dyhc.hospitalmanager.service.PackageAndCombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageAndCombinationServiceImpl implements PackageAndCombinationService {

    @Autowired
    private PackageAndCombinationMapper packageAndCombinationMapper;
}
