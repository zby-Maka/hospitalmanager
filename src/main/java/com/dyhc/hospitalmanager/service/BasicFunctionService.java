package com.dyhc.hospitalmanager.service;


import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.pojo.Package;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基础功能维护
 * author
 */
public interface BasicFunctionService {


//----------------------------------科室维护

    /**
     * 添加科室信息
     * author
     * @param section
     * @return
     */
    int addSectionInfo(Section section);

    /**
     * 修改科室信息
     * author
     * @param section
     * @return
     */
    int updSectionInfo(Section section);

    /**
     * 根据id查询科室信息
     * author
     * @param sectionId
     * @return
     */
    List<Section>getSectionInfoById(@Param("sectionId")Integer sectionId);


//----------------------------------体检项维护

    /**
     * 查询所有的体检项
     *
     * @return
     */
    List<Check> getAllCheckList();

    /**
     * 添加体检项信息
     * author
     * @param check
     * @return
     */
    int addCheckInfo(Check check);

    /**
     * 修改体检项信息
     * author
     * @param check
     * @return
     */
    int updCheckInfo(Check check);

//----------------------------------组合项项维护
    /**
     * 添加组合项信息
     * author
     * @param combination
     * checkList 体检项集合
     * @return
     */
    int addCombinationInfo(Combination combination,List<Check>checkList);

    /**
     * 修改组合项信息
     * author
     * @param combination
     * @return
     */
    int updCombinationInfo(Combination combination,List<Check>checkList);



//----------------------------------套餐项维护

    /**
     * 添加套餐信息
     * author
     * combinationList 组合项集合
     * checkList  体检项集合
     * @return
     * @throws Exception
     */
    int addPackageInfo(Package pack,List<Combination> combinationList,List<Check> checkList);

    /**
     * 修改套餐信息
     * author
     * @return
     * @throws Exception
     */
    int updPackageInfo(Package pack,List<Combination> combinationList,List<Check> checkList);



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


}
