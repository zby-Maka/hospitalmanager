package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.RoleTypeMapper;
import com.dyhc.hospitalmanager.service.RoleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleTypeServiceImpl implements RoleTypeService {

    @Autowired
    private RoleTypeMapper roleTypeMapper;
}
