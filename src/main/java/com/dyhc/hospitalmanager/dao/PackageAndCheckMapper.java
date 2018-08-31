package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.PackageAndCheck;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PackageAndCheckMapper {

    /**
     * 添加体检与套餐关系
     * @param packageAndCheck
     * @return
     */
    Integer addPackageAndCheckInfo(PackageAndCheck packageAndCheck)throws  Exception;

    /**
     * 修改体检与套餐关系
     * @param packageAndCheck
     * @return
     */
    Integer updPackageAndCheckInfo(PackageAndCheck packageAndCheck)throws  Exception;
}
