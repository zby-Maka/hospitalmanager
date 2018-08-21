package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.PackageAndCheck;

public interface PackageAndCheckMapper {
    /**
     * 李文荣
     * 添加体检与套餐关系
     * @param packageAndCheck
     * @return
     */
    Integer addPackageAndCheckInfo(PackageAndCheck packageAndCheck);
}
