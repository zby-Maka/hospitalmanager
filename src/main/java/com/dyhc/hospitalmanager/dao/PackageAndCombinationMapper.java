package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.PackageAndCombination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PackageAndCombinationMapper {

    /**
     * crf
     * 添加套餐与组合项的关系
     * @param packageAndCombination
     * @return
     */
    Integer addPackageAndCombination(@Param("packageAndCombination")PackageAndCombination packageAndCombination)throws Exception;

}
