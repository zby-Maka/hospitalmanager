package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Cost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CostMapper {

    /**
     * crf
     * 添加费用表
     * @param cost 费用表对象
     * @return 返回处理结果
     */
    Integer addCost(@Param("cost")Cost cost)throws Exception;

}
