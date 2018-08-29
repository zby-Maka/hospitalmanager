package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.RoleInfoMapper;
import com.dyhc.hospitalmanager.dao.SectionMapper;
import com.dyhc.hospitalmanager.pojo.RoleInfo;
import com.dyhc.hospitalmanager.pojo.Section;
import com.dyhc.hospitalmanager.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;
    @Autowired
    private SectionMapper sectionMapper;


    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public RoleInfo getRoleInfoLogin(String userName, String password) throws Exception {
        return roleInfoMapper.getRoleInfoLogin(userName, password);
    }

    /**
     * 根据角色id获取科室id
     * @param roleInfoId
     * @return
     */
    public Section getSectionIdByRoleInfoId(Integer roleInfoId) {
        Section section=null;
        try {
            section= sectionMapper.getSectionIdByRoleInfoId(roleInfoId);
        }catch (Exception e){
           e.printStackTrace();
        }
        return section;
    }
}
