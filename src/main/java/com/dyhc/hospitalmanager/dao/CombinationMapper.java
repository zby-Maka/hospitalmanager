package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Combination;

import com.dyhc.hospitalmanager.pojo.Combination;

import java.util.List;

public interface CombinationMapper {

    /**
     * 添加组合项信息
     * author ycy
     * @param combination
     * @return
     */
    int addCombinationInfo(Combination combination);

    /**
     * 修改组合项信息
     * author ycy
     * @param combination
     * @return
     */
    int updCombinationInfo(Combination combination);

    /**
     * 查询所有组合项，及其下的体检项
     * zby
     * @return
     */
    List<Combination> getAllCombinationList() throws Exception;
}
