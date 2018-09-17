package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.PersonInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface PersonListByGroupIdService  {
    /**
     * 查询当前分组下边的人员信息
     * @param groupId
     * @return
     * @throws Exception
     */
    List<PersonInfo> getPersonInfoListByGroupId(@Param("groupId") Integer groupId);
}
