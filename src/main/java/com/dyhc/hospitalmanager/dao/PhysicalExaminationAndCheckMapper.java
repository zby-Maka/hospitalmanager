package com.dyhc.hospitalmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PhysicalExaminationAndCheckMapper {

    /**
     * 新增用户的体检项
     * @param physicalExaminationId 体检表Id
     * @param checkId 体检项Id
     * @return
     */
    Integer addBatchPhysicalExaminationAndCheck(@Param("physicalExaminationId") String physicalExaminationId,
                                                @Param("checkId")List<Integer> checkId) throws Exception;

    /**
     *  根据体检编号和体检项id修改体检编号与体检关系表
     * @param peaId
     * @param checkId
     * @return
     */
    Integer updateStatu(@Param("peaId") String peaId,@Param("checkId")Integer checkId)throws Exception;
}
