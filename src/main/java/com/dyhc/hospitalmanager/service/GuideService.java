package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.PhysicalExamination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 打印指引单
 */
@Mapper
@Repository
public interface GuideService {
    /**
     * 添加单位预约人员与检查项的关系
     * @return 体检编号
     */
    String addRelationPerson(Integer personId,Integer[] packId,Integer packageId);
    /**
     * 根据体检编号判断人员是否已经打印过指引单
     * @return
     * @throws Exception
     */
    PhysicalExamination selectStatusByPhysicalExamination(String  physicalExaminationId);

    /**
     * 修改体检打印状态
     * @param physicalExaminationId
     * @return
     * @throws Exception
     */
    Integer updPhysicalExaminationStatus(@Param("physicalExaminationId")String physicalExaminationId);
}
