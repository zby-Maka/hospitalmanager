package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.PackageMapper;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.service.PackageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageMapper packageMapper;
}
