package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Cost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CostMapper {

    /**
     * 添加费用表
     * @param cost 费用表对象
     * @return 返回处理结果
     */
    Integer addCost(@Param("cost")Cost cost)throws Exception;

    /**
     * 根据体检编号查询该体检人是否已缴费/是否已退费
     * @param physical_examination_id
     * @return
     */
    String getCostTypeByPhysical_Examination_Id(@Param("physical_examination_id")String physical_examination_id,@Param("costType")String costType)throws Exception;

    /**
     * 根据体检编号和收费类型获取费用表id
     * @param physical_examination_id
     * @param costType
     * @return
     * @throws Exception
     */
    Integer getCostIdByPhysical_Examination_IdAndCostType(@Param("physical_examination_id")String physical_examination_id,@Param("costType")String costType)throws Exception;

}
