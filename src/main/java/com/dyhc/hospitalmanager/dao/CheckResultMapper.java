package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.CheckResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CheckResultMapper {

    /**王娇娇
     * 科室是检查:将结果插入体检结果表
     * @param checkResult
     * @return
     */
    Integer addCheckResult(CheckResult checkResult)throws Exception;

    /**
     * 根据体检编号和体检项ID查询体检结果表 白
     */
    List<CheckResult> getCheckResultsList(@Param("checkId")Integer checkId, @Param("physicalExaminationId")String physicalExaminationId) throws  Exception;

    /**
     * 体检结果和检验明细与建议显示在页面 白文鑫
     * @return
     * @throws Exception
     */
    List<CheckResult> getCheckResultAndMedicalEvents() throws  Exception;

    /***
     * 通过体检编号查询常见结果和建议
     */
    List<CheckResult> getCheckResults(@Param("physicalExaminationId")String physicalExaminationId) throws Exception;
}
