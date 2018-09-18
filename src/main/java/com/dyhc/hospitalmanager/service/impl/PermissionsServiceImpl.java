package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.PermissionsMapper;
import com.dyhc.hospitalmanager.pojo.Permissions;
import com.dyhc.hospitalmanager.service.PermissionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限-service-impl
 */
@Service
public class PermissionsServiceImpl implements PermissionsService {

    @Resource
    private PermissionsMapper permissionsMapper;

    /**
     * 根据角色编号获取对应的所有权限
     * @param roleId
     * @return
     */
    public List<Permissions> getPermissions(Integer roleId) {
        List<Permissions> permissions=null;
        try {
            permissions=permissionsMapper.getPermissions(roleId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissions;
    }
}
