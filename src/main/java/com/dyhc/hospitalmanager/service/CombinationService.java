package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.Combination;

import java.util.List;

public interface CombinationService {

    /**
     * 查询所有组合项，及其下的体检项
     * @return
     */
    List<Combination> getAllCombinationList();
}
