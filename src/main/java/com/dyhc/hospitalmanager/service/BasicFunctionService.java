package com.dyhc.hospitalmanager.service;


import com.dyhc.hospitalmanager.pojo.*;

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
     * @return
     */
    int addCombinationInfo(Combination combination);

    /**
     * 修改组合项信息
     * author ycy
     * @param combination
     * @return
     */
    int updCombinationInfo(Combination combination);



//----------------------------------套餐项维护

    /**
     * 添加套餐信息
     * author ycy
     * @return
     * @throws Exception
     */
    int addPackageInfo();

    /**
     * 修改套餐信息
     * author ycy
     * @return
     * @throws Exception
     */
    int updPackageInfo();



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
