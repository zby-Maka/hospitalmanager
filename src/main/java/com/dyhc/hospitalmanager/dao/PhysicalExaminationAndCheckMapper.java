package com.dyhc.hospitalmanager.dao;

import org.apache.ibatis.annotations.Param;

public interface PhysicalExaminationAndCheckMapper {

    /**
     * zby
     * 新增用户的体检项
     * @param physicalExaminationId 体检表Id
     * @param checkId 体检项Id
     * @return
     */
    Integer addPhysicalExaminationAndCheck(@Param("physicalExaminationId") String physicalExaminationId, @Param("checkId") Integer checkId);
}
