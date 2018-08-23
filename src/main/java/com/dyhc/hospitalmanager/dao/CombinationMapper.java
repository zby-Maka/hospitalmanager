package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Combination;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dyhc.hospitalmanager.pojo.Combination;

import java.util.List;
@Mapper
@Repository
public interface CombinationMapper {

    /**
     * 添加组合项信息
     * author ycy
     * @param combination
     * @return
     */
    int addCombinationInfo(Combination combination)throws  Exception;

    /**
     * 修改组合项信息
     * author ycy
     * @param combination
     * @return
     */
    int updCombinationInfo(Combination combination) throws Exception;

    /**
     * 查询所有组合项，及其下的体检项
     * zby
     * @return
     */
    List<Combination> getAllCombinationList() throws Exception;
}
