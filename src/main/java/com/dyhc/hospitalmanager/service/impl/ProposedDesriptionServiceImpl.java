package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.ProposedDescriptionMapper;
import com.dyhc.hospitalmanager.pojo.ProposedDescription;
import com.dyhc.hospitalmanager.service.ProposedDesriptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProposedDesriptionServiceImpl implements ProposedDesriptionService {
    @Resource
    private ProposedDescriptionMapper proposedDescriptionMapper;

    @Override
    public List<ProposedDescription> getProposedDescriptionlist(Integer resultId){
        try {
            return proposedDescriptionMapper.getProposedDescriptionlist(resultId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addProposedDescriptionInfo(ProposedDescription proposedDescription) {
        int result=0;
        try {
            result=proposedDescriptionMapper.addProposedDescriptionInfo(proposedDescription);
        } catch (Exception e) {
            e.printStackTrace();
            result=0;
        }
        return result;
    }

    @Override
    public int updProposedDescriptionInfo(ProposedDescription proposedDescription) {
        int result=0;
        try {
            result=proposedDescriptionMapper.updProposedDescriptionInfo(proposedDescription);
        } catch (Exception e) {
            e.printStackTrace();
            result=0;
        }
        return result;
    }

    @Override
    public ProposedDescription getProposedDescriptionByid(Integer proposedDescriptionId) {
        try {
            return proposedDescriptionMapper.getProposedDescriptionByid(proposedDescriptionId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
