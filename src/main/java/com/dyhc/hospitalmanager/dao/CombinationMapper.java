package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Combination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CombinationMapper {

    /**
     * 添加组合项信息
     * @param combination
     * @return
     */
    int addCombinationInfo(Combination combination)throws  Exception;


    /**
     * 根据组合项id查询组合项信息以及下的体检项信息
     * @return
     */
    List<Combination> getCheckByCombinationId(@Param("combinationId") Integer combinationId)throws Exception;

    /**
     * 根据一组组合项Id，查询组合项信息以及下的体检项信息
     * @param combinationId 一组Array
     * @return
     * @throws Exception
     */
    List<Combination> getCheckByComArrayId(@Param("combinationId") Integer[] combinationId) throws Exception;

    /**
     * 修改组合项信息
     * @param combination
     * @return
     */
    int updCombinationInfo(Combination combination) throws Exception;

    /**
     * 查询所有组合项，及其下的体检项
     * @return
     */
    List<Combination> getAllCombinationList() throws Exception;

    /**
     * 根据体检Id查询组合信息
     * @return
     */
    List<Combination> getCombinationByPhysicalExaminationId(@Param("physicalExaminationId")String physicalExaminationId)throws Exception;

    /**
     * 根据科室编号查询组合项信息
     * @param sectionId
     * @return
     * @throws Exception
     */
    List<Combination> getCombinationList(@Param("sectionId")Integer sectionId)throws Exception;
}
