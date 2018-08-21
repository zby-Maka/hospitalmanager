package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CompanyInfoMapper;
import com.dyhc.hospitalmanager.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Autowired
    private CompanyInfoMapper companyInfoMapper;
}
