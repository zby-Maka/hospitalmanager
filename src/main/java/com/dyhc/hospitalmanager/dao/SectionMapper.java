package com.dyhc.hospitalmanager.dao;

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
}
