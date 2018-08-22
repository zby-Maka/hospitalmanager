package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Combination;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CombinationMapper {

    /**
     * 查询所有组合项，及其下的体检项
     * zby
     * @return
     */
    List<Combination> getAllCombinationList() throws Exception;
}
