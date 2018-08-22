package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.CommonResults;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonResultsMapper {

    /**王娇娇
     * 科室是检查:根据体检项id查常见结果表，默认显示第一条
     * @param checkId
     * @return
     */
    List<CommonResults> getCommResultsByCheckId(@Param("checkId")Integer checkId)throws Exception;

    /**
     * 添加常见结果信息
     * author ycy
     * @param commonResults
     * @return
     */
    int addCommonResultsInfo(CommonResults commonResults);

    /**
     * 修改常见结果信息
     * author ycy
     * @param commonResults
     * @return
     */
    int updCommonResultsInfo(CommonResults commonResults);

}
