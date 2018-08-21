package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Group;

public interface GroupMapper {
    /**
     * lwr
     * 添加单位分组信息
     * @param group
     * @return
     */
    Integer addGroupInfo(Group group)throws  Exception;
}
