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
}
