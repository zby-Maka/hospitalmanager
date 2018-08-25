package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.ProposedDescription;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ProposedDescriptionMapper {

    /**
     * 科室是检查:根据结果id查建议描述表，默认显示第一条
     * @param resultId
     * @return
     */
    List<ProposedDescription> getProposedByResultId(@Param("resultId") Integer resultId)throws Exception;


    /**
     * 添加建议描述信息
     * @param proposedDescription
     * @return
     */
    int addProposedDescriptionInfo(ProposedDescription proposedDescription)throws Exception;

    /**
     * 修改建议描述信息
     * @param proposedDescription
     * @return
     */
    int updProposedDescriptionInfo(ProposedDescription proposedDescription) throws Exception;


}
