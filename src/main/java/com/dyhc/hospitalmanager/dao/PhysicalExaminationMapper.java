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
     * 根据档案编号查询体检信息
     * author ycy
     * @param archivesId
     * @return
     */
    List<PhysicalExamination>getPhysicalExaminationInfoByArchivesId(@Param("archivesId") String archivesId);
}
