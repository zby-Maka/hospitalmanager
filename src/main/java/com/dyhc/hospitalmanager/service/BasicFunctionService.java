package com.dyhc.hospitalmanager.service;


import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.pojo.Package;

import java.util.List;

/**
 * 基础功能维护
 * author ycy
 */
public interface BasicFunctionService {


//----------------------------------科室维护

    /**
     * 添加科室信息
     * author ycy
     * @param section
     * @return
     */
    int addSectionInfo(Section section);

    /**
     * 修改科室信息
     * author ycy
     * @param section
     * @return
     */
    int updSectionInfo(Section section);


//----------------------------------体检项维护

    /**
     * 查询所有的体检项
     * zby
     * @return
     */
    List<Check> getAllCheckList();

    /**
     * 添加体检项信息
     * author ycy
     * @param check
     * @return
     */
    int addCheckInfo(Check check);

    /**
     * 修改体检项信息
     * author ycy
     * @param check
     * @return
     */
    int updCheckInfo(Check check);

//----------------------------------组合项项维护
    /**
     * 添加组合项信息
     * author ycy
     * @param combination
     * checkList 体检项集合
     * @return
     */
    int addCombinationInfo(Combination combination,List<Check>checkList);

    /**
     * 修改组合项信息
     * author ycy
     * @param combination
     * @return
     */
    int updCombinationInfo(Combination combination,List<Check>checkList);



//----------------------------------套餐项维护

    /**
     * 添加套餐信息
     * author ycy
     * combinationList 组合项集合
     * checkList  体检项集合
     * @return
     * @throws Exception
     */
    int addPackageInfo(Package pack,List<Combination> combinationList,List<Check> checkList);

    /**
     * 修改套餐信息
     * author ycy
     * @return
     * @throws Exception
     */
    int updPackageInfo(Package pack,List<Combination> combinationList,List<Check> checkList);



//----------------------------------常见结果维护

    /**
     * 添加常见结果信息
     * author ycy
     * @param commonResults
     * @return
     */
    int addCommonResultsInfo(CommonResults commonResults);

    /**
     * 修改常见结果信息
     * author ycy
     * @param commonResults
     * @return
     */
    int updCommonResultsInfo(CommonResults commonResults);


//----------------------------------建议描述维护


    /**
     * 添加建议描述信息
     *   author ycy
     * @param proposedDescription
     * @return
     */
    int addProposedDescriptionInfo(ProposedDescription proposedDescription);

    /**
     * 修改建议描述信息
     * author ycy
     * @param proposedDescription
     * @return
     */
    int updProposedDescriptionInfo(ProposedDescription proposedDescription);


}
