package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.PhysicalExamination;
import org.apache.ibatis.annotations.Param;

public interface PhysicalExaminationMapper {


    /**
     * 添加体检项目信息
     * author ycy
     * @param physicalExamination
     * @return
     */
    int addPhysicalExaminationInfo(PhysicalExamination physicalExamination)throws  Exception;

    /**
     * 根据当前日期查询体检表倒叙第一条的体检编号
     * @param now
     * @return
     */
    String getPhysicalExaminationOrderByMedicalTime(@Param("now")String now)throws  Exception;

}
