package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.ProposedDescription;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProposedDesriptionService {
    /**
     * 查询建议
     */
    List<ProposedDescription> getProposedDescriptionlist(Integer resultId);
    /**
     * 添加建议描述信息
     * @param proposedDescription
     * @return
     */
    int addProposedDescriptionInfo(ProposedDescription proposedDescription);

    /**
     * 修改建议描述信息
     * @param proposedDescription
     * @return
     */
    int updProposedDescriptionInfo(ProposedDescription proposedDescription);
    /**
     * 通过id赋值
     */
    ProposedDescription getProposedDescriptionByid(Integer proposedDescriptionId);
}
