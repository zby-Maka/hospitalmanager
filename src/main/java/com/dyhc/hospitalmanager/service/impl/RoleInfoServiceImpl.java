package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.RoleInfoMapper;
import com.dyhc.hospitalmanager.dao.SectionMapper;
import com.dyhc.hospitalmanager.pojo.RoleInfo;
import com.dyhc.hospitalmanager.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;
    @Autowired
    private SectionMapper sectionMapper;


    @Override
    public RoleInfo getRoleInfoLogin(String userName, String password) throws Exception {
        return roleInfoMapper.getRoleInfoLogin(userName, password);
    }

    @Override
    public Integer getSectionIdByRoleInfoId(Integer roleInfoId) {
        Integer a=0;
        try {
           a= sectionMapper.getSectionIdByRoleInfoId(roleInfoId);
        }catch (Exception e){
           e.printStackTrace();
        }
        return a;
    }
}
