package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.CheckResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckResultService {
    /***
     * 通过体检编号查询常见结果和建议
     */
    List<CheckResult> getCheckResults(String physicalExaminationId);
}
