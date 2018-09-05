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
    List<Group> groupListByCompanyId(@Param("companyId") Integer companyId)throws  Exception;

    /**
     * 根据分组id查询
     * @param groupId
     * @return
     */
    Group groupInfoByGroupId(@Param("groupId") Integer groupId)throws  Exception;

    /**
     * 根据单位分组id 查询信息
     * @param groupId
     * @return
     */
    Group showGroupDetails(@Param("groupId") Integer groupId)throws  Exception;

    /**
     * 修改单位状态
     * @param isDelete
     * @return
     */
    Integer updGroup(@Param("isDelete") Integer isDelete,@Param("groupId") Integer groupId)throws  Exception;

    /**
     * 根据分组名称查询分组是否存在
     * @param groupName
     * @return
     * @throws Exception
     */
    Group selectByGroupName(@Param("groupName") String groupName)throws  Exception;
}
