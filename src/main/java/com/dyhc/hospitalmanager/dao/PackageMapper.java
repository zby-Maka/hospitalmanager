package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Package;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PackageMapper {

    /**
     * 根据套餐Id查询其下面的所有组合项
     * @param packageId 套餐Id
     * @return
     */
    Package getPackageCombination(@Param("packageId") Integer packageId);

    /**
     * 根据套餐Id查询套餐下的体检项
     * @param packageId 套餐id
     * @return
     */
    Package getPackageCheck(@Param("packageId") Integer packageId);

    /**
     * 获取所有套餐的Id
     * @return
     */
    List<Integer> getAllPackageId();
}
