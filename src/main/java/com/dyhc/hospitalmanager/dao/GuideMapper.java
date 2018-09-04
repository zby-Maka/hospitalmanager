package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Check;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GuideMapper {
    /**
     * 打印指引单 根据体检编号和身份证号查询体检信息
     * @param physicalExaminationId
     * @return
     * @throws Exception
     */
    List<Check> showListCheck(@Param("physicalExaminationId")String physicalExaminationId)throws Exception;

    /**
     * 根据身份证号查询套餐id
     * @return
     * @throws Exception
     */
    int getPackageId(@Param("personIdCard")String personIdCard)throws Exception;

    /**
     * 根据套餐id显示所有的体检信息
     * @param packageId
     * @return
     * @throws Exception
     */
    List<Check> listCheckId(@Param("packageId")Integer packageId)throws Exception;

}
