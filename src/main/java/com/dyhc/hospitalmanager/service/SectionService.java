package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SectionService {

    /**
     * 根据体检编号查询人员在该科室下的体检项
     * @param peacId
     * @return
     * @throws Exception
     */
    List<Check> getPersonCheckBySectionId(@Param("peacId")String peacId, @Param("sectionId")Integer sectionId) throws  Exception;


    /**
     * 科室是检查:根据体检项id查常见结果表，默认显示第一条
     * 科室是检查:根据结果id查建议描述表，默认显示第一条
     * @param checkId
     * @return
     */
    Map<String,Object> getCheckResultAndProposed(@Param("checkId")Integer checkId, @Param("resultId") Integer resultId,Integer sectionId)throws Exception;


    /**
     * 科室是检查:将结果插入体检结果表
     * 科室是检验:将检验结果添加到检验明细表中和插入体检结果表
     * @param checkResult
     * @param medicalEvents
     * @param sectionId
     * @return
     * @throws Exception
     */
    Integer addCheckResultAndMedicalEvent(CheckResult checkResult,MedicalEvents medicalEvents,Integer sectionId)throws Exception;


}
