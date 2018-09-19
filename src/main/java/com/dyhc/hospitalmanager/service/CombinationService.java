package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.Combination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CombinationService {

    /**
     * 查询所有组合项，及其下的体检项
     * @return
     */
    List<Combination> getAllCombinationList();

    /**
     * 根据一组组合项Id，查询组合项信息以及下的体检项信息
     * @param combinationId 一组Array
     * @return
     * @throws Exception
     */
   List<Combination> getCheckByComArrayId(@Param("combinationId") Integer[] combinationId) throws Exception;

}
