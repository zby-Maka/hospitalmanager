package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Check;
import com.dyhc.hospitalmanager.pojo.Section;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SectionMapper {

    /**
     * 添加科室信息
     * @param section
     * @return
     */
    int addSectionInfo(Section section)throws  Exception;

    /**
     * 修改科室信息
     * @param section
     * @return
     */
    int updSectionInfo(Section section) throws Exception;


    /**
     * 根据id查询科室信息
     * @param sectionId
     * @return
     */
    List<Section>getSectionInfoById(@Param("sectionId")Integer sectionId)throws Exception;

    /**
     * 根据角色id获取科室id
     * @param roleInfoId
     * @return
     */

    /**
     * 查询科室下的体检项和组合项
     * @return
     */
    List<Check>getSectionAndCheckAndCombinationInfo()throws  Exception;

    /**
     * 根据科室id查询科室下的体检项和组合项
     * @return
     */
    List<Check>getSectionAndCheckAndCombinationInfoById(@Param("sectionId")Integer sectionId)throws Exception;

    /**
     * 根据角色id获取科室对象
     * @param roleInfoId
     * @return
     */
    Section getSectionIdByRoleInfoId(@Param("roleInfoId") Integer roleInfoId)throws Exception;
    /**
     * 通过科室id赋值
     */
    Section getSectionsectionId(@Param("sectionId")Integer sectionId) throws Exception;

    /**
     * 查询所有科室信息
     * @return
     */
    List<Section> getSectionList()throws Exception;

}
