package com.dyhc.hospitalmanager.service;


import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.pojo.Package;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基础功能维护
 */
public interface BasicFunctionService {


//----------------------------------科室维护

    /**
     * 添加科室信息
     * @param section
     * @return
     */
    int addSectionInfo(Section section);

    /**
     * 修改科室信息
     * @param section
     * @return
     */
    int updSectionInfo(Section section);

    /**
     * 根据id查询科室信息
     * @param sectionId
     * @return
     */
    List<Section>getSectionInfoById(@Param("sectionId")Integer sectionId);


//----------------------------------体检项维护

    /**
     * 查询所有的体检项
     * @return
     */
    List<Check> getAllCheckList();

    /**
     * 添加体检项信息
     * @param check
     * @return
     */
    int addCheckInfo(Check check);


    /**
     * 根据体检项id查询体检项信息
     * @return
     * @throws Exception
     */
    List<Check>getAllCheckInfoById(@Param("checkId") Integer checkId);

    /**
     * 修改体检项信息
     * @param check
     * @return
     */
    int updCheckInfo(Check check);

//----------------------------------组合项项维护
    /**
     * 添加组合项信息
     * @param combination
     * checkList 体检项集合
     * @return
     */
    int addCombinationInfo(Combination combination,Integer[] CheckList);




    /**
     * 修改组合项信息
     * @param combination
     * @return
     */
    int updCombinationInfo(Combination combination);

    /**
     * 根据组合项id查询组合项信息以及下的体检项信息
     * @param combinationId
     * @return
     */
   // List<Check> getCheckByCombinationId(@Param("combinationId")Integer combinationId);
    List<Combination> getCheckByCombinationId(@Param("combinationId") Integer combinationId);



//----------------------------------套餐项维护


    /**
     * 查询科室下的体检项和组合项
     * @return
     */
    List<Check>getSectionAndCheckAndCombinationInfo();

    /**
     * 根据科室id查询科室下的体检项和组合项
     * @return
     */
    List<Check>getSectionAndCheckAndCombinationInfoById(@Param("sectionId")Integer sectionId);



    /**
     * 查询套餐信息
     * @return
     */
    List<Package> showAllPackage();

    /**
     * 添加套餐信息
     * combinationList 组合项集合
     * checkList  体检项集合
     * @return
     * @throws Exception
     */
    int addPackageInfo(Package pack,Integer[] CombiantionList,Integer[] CheckList);

    /**
     * 根据套餐id查询套餐信息以及下的组合项
     * @param packageId
     * @return
     */
    List<Package>getPackageAndCombinationInfoById(@Param("packageId")Integer packageId);

    /**
     * 根据套餐id查询套餐信息以及下的体检项
     * @param packageId
     * @return
     */
    List<Package>getPackageAndCheckInfoById(@Param("packageId")Integer packageId);


    /**
     * 修改套餐信息
     * @return
     * @throws Exception
     */
    int updPackageInfo(Package pack);



//----------------------------------常见结果维护

    /**
     * 添加常见结果信息
     * author
     * @param commonResults
     * @return
     */
    int addCommonResultsInfo(CommonResults commonResults);

    /**
     * 修改常见结果信息
     * author
     * @param commonResults
     * @return
     */
    int updCommonResultsInfo(CommonResults commonResults);

    /**
     * 根据主键id查询常见结果信息
     * @param commonResultsId
     * @return
     */
    List<CommonResults> getAllCommonResultsById(@Param("commonResultsId")Integer commonResultsId);


//----------------------------------建议描述维护


    /**
     * 添加建议描述信息
     *   author
     * @param proposedDescription
     * @return
     */
    int addProposedDescriptionInfo(ProposedDescription proposedDescription);

    /**
     * 修改建议描述信息
     * author
     * @param proposedDescription
     * @return
     */
    int updProposedDescriptionInfo(ProposedDescription proposedDescription);


    /**
     * 根据主键id查询建议描述信息
     * author
     * @param proposedDescriptionId
     * @return
     * @throws Exception
     */
    List<ProposedDescription>getAllProposedDescriptionInfoById(@Param("proposedDescriptionId")Integer proposedDescriptionId);

    /**
     *查询科室信息以及其下的组合项和体检项信息
     * @return
     */
    List<Section> getSectionList();

}
