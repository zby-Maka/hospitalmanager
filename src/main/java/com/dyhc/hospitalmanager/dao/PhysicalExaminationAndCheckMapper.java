package com.dyhc.hospitalmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PhysicalExaminationAndCheckMapper {

    /**
     * zby
     * 新增用户的体检项
     * @param physicalExaminationId 体检表Id
     * @param checkId 体检项Id
     * @return
     */
    Integer addBatchPhysicalExaminationAndCheck(@Param("physicalExaminationId") String physicalExaminationId, @Param("checkId") Integer[] checkId) throws Exception;
}
