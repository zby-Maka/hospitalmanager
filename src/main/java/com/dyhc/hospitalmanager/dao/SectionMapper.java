package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Section;

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
