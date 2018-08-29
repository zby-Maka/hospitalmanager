package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GroupMapper {
    /**
     * 添加单位分组信息
     * @param group
     * @return
     */
    Integer addGroupInfo(Group group)throws  Exception;

    /**
     *根据公司id查询单位分组
     * @return
     */
    List<Group> groupListByCompanyId(@Param("companyId") Integer companyId);

    /**
     * 根据分组id查询
     * @param groupId
     * @return
     */
    Group groupInfoByGroupId(@Param("groupId") Integer groupId);
}
