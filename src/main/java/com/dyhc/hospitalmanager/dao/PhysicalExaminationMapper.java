package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.PhysicalExamination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhysicalExaminationMapper {


    /**
     * 添加体检项目信息
     * author ycy
     * @param physicalExamination
     * @return
     */
    int addPhysicalExaminationInfo(PhysicalExamination physicalExamination)throws  Exception;

    /**
     * 根据用户Id查询历史体检记录
     * zby
     * @param personId 人员编号
     * @return
     */
    List<PhysicalExamination> getPersonPhysicalExaminationList(@Param("personId") Integer personId);

    /**
     * 根据当前日期查询体检表倒叙第一条的体检编号
     * @param now
     * @return
     */
    String getPhysicalExaminationOrderByMedicalTime(@Param("now")String now)throws  Exception;


    /**
     * 根据档案编号查询体检信息
     * author ycy
     * @param archivesId
     * @return
     */
    List<PhysicalExamination>getPhysicalExaminationInfoByArchivesId(@Param("archivesId") String archivesId);


    /**
     * 修改体检表档案编号和时间
     * @param physicalExamination
     * author ycy
     * @return
     */
    int updPhysicalExaminationInfo(PhysicalExamination physicalExamination);

    /**
     * 查询体检表最后一位倒序
     * @return
     * author ycy
     * @throws Exception
     */
    PhysicalExamination getPhysicalExaminationIdByDesc() throws Exception;

}
