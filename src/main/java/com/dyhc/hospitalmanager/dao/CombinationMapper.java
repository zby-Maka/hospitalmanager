package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Combination;

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
}
