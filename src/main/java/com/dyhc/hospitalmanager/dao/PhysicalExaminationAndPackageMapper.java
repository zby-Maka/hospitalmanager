package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.PhysicalExaminationAndPackage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PhysicalExaminationAndPackageMapper {

    /**
     * 新增用户选择的套餐
     * zby
     * @param physicalExaminationId 体检表Id
     * @param packageId 套餐Id
     * @return
     */
    Integer addPhysicalExaminationAndPackageMapper(@Param("physicalExaminationId") String physicalExaminationId,@Param("packageId")Integer packageId);

    /**
     * 李文荣
     * 添加体检与套餐关系
     * @param physicalExaminationAndPackage
     * @return
     */
    Integer addPhyAndPackage(PhysicalExaminationAndPackage physicalExaminationAndPackage);
}
