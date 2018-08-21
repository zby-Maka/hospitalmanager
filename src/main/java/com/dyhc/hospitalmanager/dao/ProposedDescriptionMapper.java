package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.ProposedDescription;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProposedDescriptionMapper {
    /**王娇娇
     * 根据结果id查建议描述表，默认显示第一条
     * @param resultId
     * @return
     */
    List<ProposedDescription> getProposedByResultId(@Param("resultId") Integer resultId)throws Exception;
}
