package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Combination;
import com.dyhc.hospitalmanager.pojo.CombinationAndCheck;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.dyhc.hospitalmanager.pojo.Check;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CombinationAndCheckMapper {

    /**
     * 周冰洋
     * 根据组合项Id，查询其下的所有体检项
     * @param comId 组合项Id
     * @return
     */
    List<Check> getCheckByCombinationId(@Param("comId")Integer comId)throws  Exception;

    /**
     * crf
     * 添加组合项和体检项的关系
     * @param combinationAndCheck
     * @return
     * @throws Exception
     */
    Integer addCombinationAndCheck(@Param("combinationAndCheck")CombinationAndCheck combinationAndCheck)throws Exception;
}
