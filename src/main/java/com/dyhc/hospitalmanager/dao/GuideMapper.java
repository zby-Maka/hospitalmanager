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
     * 打印指引单 根据体检编号查询体检信息
     * @param physicalExaminationId
     * @return
     * @throws Exception
     */
    List<Check> showListCheck(@Param("physicalExaminationId")String physicalExaminationId)throws Exception;

}
