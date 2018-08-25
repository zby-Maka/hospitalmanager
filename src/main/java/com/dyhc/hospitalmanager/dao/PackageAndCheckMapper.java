package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.PackageAndCheck;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PackageAndCheckMapper {

    /**
     * 李文荣
     * 添加体检与套餐关系
     * @param packageAndCheck
     * @return
     */
    Integer addPackageAndCheckInfo(PackageAndCheck packageAndCheck)throws  Exception;
}
