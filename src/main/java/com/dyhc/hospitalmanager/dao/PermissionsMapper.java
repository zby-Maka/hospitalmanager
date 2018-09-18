package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Permissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限-dao
 */
public interface PermissionsMapper {

    /**
     * 根据角色编号获取对应的所有权限
     * @param roleId
     * @return
     */
    List<Permissions> getPermissions(@Param("roleId") Integer roleId) throws Exception;
}
