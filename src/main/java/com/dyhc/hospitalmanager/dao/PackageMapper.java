package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Package;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PackageMapper {

    /**
     * 周冰洋
     * 根据套餐Id查询其下面的所有组合项
     * @param packageId 套餐Id
     * @return
     */
    Package getPackageCombination(@Param("packageId") Integer packageId)throws  Exception;

    /**
     * 周冰洋
     * 根据套餐Id查询套餐下的体检项
     * @param packageId 套餐id
     * @return
     */
    Package getPackageCheck(@Param("packageId") Integer packageId)throws  Exception;

    /**
     * 周冰洋
     * 获取所有套餐的Id
     * @return
     */
    List<Integer> getAllPackageId()throws  Exception;

    /**
     * 李文荣
     * 获取所有套餐
     * @return
     */
    List<Package> showAllPackage()throws  Exception;

    /**
     * 根据套餐Id，获取该套餐
     * zby
     * @param packageId 套餐Id
     * @return
     */
    Package selPackageById(@Param("packageId") Integer packageId);

    /**
     * 添加套餐信息
     * author ycy
     * @return
     * @throws Exception
     */
    int addPackageInfo() throws Exception;

    /**
     * 修改套餐信息
     * author ycy
     * @return
     * @throws Exception
     */
    int updPackageInfo() throws Exception;
}
