package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.CheckResult;

public interface CheckResultMapper {
    /**王娇娇
     * 科室是检查:将结果插入体检结果表
     * @param checkResult
     * @return
     */
    Integer addCheckResult(CheckResult checkResult)throws Exception;
}
