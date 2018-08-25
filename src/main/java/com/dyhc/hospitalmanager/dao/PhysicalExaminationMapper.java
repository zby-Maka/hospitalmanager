package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.PhysicalExamination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PhysicalExaminationMapper {


    /**
     * 添加体检项目信息
     * @param physicalExamination
     * @return
     */
    int addPhysicalExaminationInfo(PhysicalExamination physicalExamination)throws  Exception;

    /**
     * 根据用户Id查询历史体检记录
     * @param personId 人员编号
     * @return
     */
    List<PhysicalExamination> getPersonPhysicalExaminationList(@Param("personId") Integer personId) throws Exception;

    /**
     * 根据当前日期查询体检表倒叙第一条的体检编号
     * @param medicalTime 当前时间
     * @return 返回一个检查编号
     */
    String getPhysicalExaminationOrderByMedicalTime(@Param("medicalTime")String medicalTime)throws  Exception;


    /**
     * 根据档案编号查询体检信息
     * @param archivesId
     * @return
     */
    List<PhysicalExamination>getPhysicalExaminationInfoByArchivesId(@Param("archivesId") String archivesId)throws Exception;


    /**
     * 修改体检表档案编号和时间
     * @param physicalExamination
     * @return
     */
    int updPhysicalExaminationInfo(PhysicalExamination physicalExamination)throws Exception;

    /**
     * 查询体检表最后一位倒序
     * @return
     * @throws Exception
     */
    PhysicalExamination getPhysicalExaminationIdByDesc() throws Exception;

    /**
     * 根据人员Id查询体检编号
     * @return
     * @throws Exception
     */
    String getPhysicalExaminationByPersonId(@Param("personId")Integer personId)throws Exception;

}
