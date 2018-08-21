package com.dyhc.hospitalmanager.dao;

import org.apache.ibatis.annotations.Param;

public interface PhysicalExaminationAndCombinationMapper {

    /**
     * 新增用户选择的组合项
     * zby
     * @param physicalExaminationId 组合项Id
     * @param combinationId 体检表Id
     * @return
     */
    Integer addPhysicalExaminationAndCombination(@Param("physicalExaminationId") String physicalExaminationId, @Param("combinationId") Integer combinationId);
}
