package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CombinationMapper;
import com.dyhc.hospitalmanager.pojo.Combination;
import com.dyhc.hospitalmanager.service.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombinationServiceImpl implements CombinationService {

    @Autowired
    private CombinationMapper combinationMapper;

    @Override
    public List<Combination> getAllCombinationList() {
        try {
            return combinationMapper.getAllCombinationList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Combination> getCheckByComArrayId(Integer[] combinationId) throws Exception {
        try {
            return combinationMapper.getCheckByComArrayId(combinationId);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
}
