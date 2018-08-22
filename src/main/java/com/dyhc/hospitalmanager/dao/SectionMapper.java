package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Section;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SectionMapper {

    /**
     * 添加科室信息
     * author ycy
     * @param section
     * @return
     */
    int addSectionInfo(Section section)throws  Exception;

    /**
     * 修改科室信息
     * author ycy
     * @param section
     * @return
     */
    int updSectionInfo(Section section) throws Exception;
}
