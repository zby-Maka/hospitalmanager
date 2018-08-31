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
     * 根据套餐Id查询其下面的所有组合项
     * @param packageId 套餐Id
     * @return
     */
    Package getPackageCombination(@Param("packageId") Integer packageId)throws  Exception;

    /**
     * 根据套餐Id查询套餐下的体检项
     * @param packageId 套餐id
     * @return
     */
    Package getPackageCheck(@Param("packageId") Integer packageId)throws  Exception;

    /**
     * 获取所有套餐的Id
     * @return
     */
    List<Integer> getAllPackageId()throws  Exception;

    /**
     * 获取所有套餐
     * @return
     */
    List<Package> showAllPackage()throws  Exception;

    /**
     * 根据套餐Id，获取该套餐
     * @param packageId 套餐Id
     * @return
     */
    Package selPackageById(@Param("packageId") Integer packageId) throws Exception;

    /**
     * 添加套餐信息
     * @return
     * @throws Exception
     */
    int addPackageInfo(Package pack) throws Exception;

    /**
     * 修改套餐信息
     * @return
     * @throws Exception
     */
    int updPackageInfo(Package pack) throws Exception;


    /**
     * 根据体检编号查询套餐信息
     * @return
     */
    List<Package> getPackageByPhysicalExaminationId(@Param("physicalExaminationId")String physicalExaminationId)throws Exception;

    /**
     * 根据套餐id查询套餐信息以及下的组合项
     * @param packageId
     * @return
     */
    List<Package>getPackageAndCombinationInfoById(@Param("packageId")Integer packageId) throws Exception;

    /**
     * 根据套餐id查询套餐信息以及下的体检项
     * @param packageId
     * @return
     */
    List<Package>getPackageAndCheckInfoById(@Param("packageId")Integer packageId) throws Exception;

}
