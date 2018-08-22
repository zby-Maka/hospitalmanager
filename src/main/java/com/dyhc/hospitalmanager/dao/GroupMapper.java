package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Group;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GroupMapper {
    /**
     * lwr
     * 添加单位分组信息
     * @param group
     * @return
     */
    Integer addGroupInfo(Group group)throws  Exception;
}
