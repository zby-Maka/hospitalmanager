package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.Permissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 权限-service
 */
public interface PermissionsService {

    /**
     * 根据角色编号获取对应的所有权限
     * @param roleId
     * @return
     */
    List<Permissions> getPermissions(Integer roleId);
}
