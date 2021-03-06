package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SectionService {

    /**
     * 根据体检编号查询人员
     * 根据体检编号查询人员在该科室下的体检项
     * @param peacId
     * @return
     * @throws Exception
     */
    Map<String,Object> getPersonCheckBySectionId(@Param("peacId")String peacId, @Param("sectionId")Integer sectionId);

    /**
     * 科室是检查:根据体检项id查常见结果表，默认显示第一条
     * @param checkId
     * @return
     */
    CommonResults  getCommResultsByCheckId(@Param("checkId")Integer checkId,Integer sectionId);

    /**
     * 科室是检查:根据结果id查建议描述表，默认显示第一条
     * @param resultId
     * @return
     */
    List<ProposedDescription> getProposedByResultId(@Param("resultId") Integer resultId,Integer sectionId);


    /**
     * 科室是检查:将结果插入体检结果表
     * 科室是检验:将检验结果添加到检验明细表中和插入体检结果表
     * @param checkResult
     * @param medicalEvents
     * @param sectionId
     * @return
     * @throws Exception
     */
    Integer addCheckResultAndMedicalEvent(CheckResult checkResult,List<MedicalEvents> medicalEvents,Integer sectionId);
    /**
     *  根据体检编号和体检项id修改体检编号与体检关系表
     * @param peaId
     * @param checkId
     * @return
     */
    Integer updateStatu(@Param("peaId") String peaId,@Param("checkId")Integer checkId);



    /**
     * 添加科室信息
     * @param section
     * @return
     */
    int addSectionInfo(Section section);

    /**
     * 通过科室id赋值
     */
    Section getSectionsectionId(@Param("sectionId")Integer sectionId);
    /**
     * 修改科室信息
     * @param section
     * @return
     */
    int updSectionInfo(Section section);


}
