package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.RoleInfo;
import com.dyhc.hospitalmanager.pojo.Section;
import org.apache.ibatis.annotations.Param;

public interface RoleInfoService {
    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    RoleInfo getRoleInfoLogin( String userName, String password) throws Exception;

    /**
     * 根据角色id获取科室id
     * @param roleInfoId
     * @return
     */
    Section getSectionIdByRoleInfoId(@Param("roleInfoId") Integer roleInfoId);
}
