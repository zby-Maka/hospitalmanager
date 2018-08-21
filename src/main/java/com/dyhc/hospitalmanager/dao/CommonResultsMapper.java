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

}
