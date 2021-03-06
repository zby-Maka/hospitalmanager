package com.dyhc.hospitalmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PhysicalExaminationAndCombinationMapper {

    /**
     * 新增用户选择的组合项
     * @param physicalExaminationId 组合项Id
     * @param combinationId 体检表Id
     * @return
     */
    Integer addBatchPhysicalExaminationAndCombination(@Param("physicalExaminationId") String physicalExaminationId, @Param("combinationId") Integer[] combinationId) throws Exception;
}
