package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.RoleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleInfoMapper {
    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    RoleInfo getRoleInfoLogin(@Param("userName") String userName,@Param("password") String password) throws Exception;

}
