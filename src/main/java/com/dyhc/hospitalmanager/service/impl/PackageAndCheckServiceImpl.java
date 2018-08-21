package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.PackageAndCheckMapper;
import com.dyhc.hospitalmanager.service.PackageAndCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageAndCheckServiceImpl implements PackageAndCheckService {

    @Autowired
    private PackageAndCheckMapper packageAndCheckMapper;
}
