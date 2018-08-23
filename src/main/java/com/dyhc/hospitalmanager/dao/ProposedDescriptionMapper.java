package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.ProposedDescription;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ProposedDescriptionMapper {

    /**王娇娇
     * 科室是检查:根据结果id查建议描述表，默认显示第一条
     * @param resultId
     * @return
     */
    List<ProposedDescription> getProposedByResultId(@Param("resultId") Integer resultId)throws Exception;



}
