package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.PhysicalExamination;
import org.apache.ibatis.annotations.Param;

public interface PhysicalExaminationService {

    /**
     * 添加体检信息
     * author
     * @param physicalExamination
     * @return
     */
    int addPhysicalExaminationInfo(PhysicalExamination physicalExamination);

    /**
     * 根据当前日期查询体检表倒序第一条的体检编号
     * @return
     */
    String getPhysicalExaminationOrderByMedicalTime(String medicalTime);

}
