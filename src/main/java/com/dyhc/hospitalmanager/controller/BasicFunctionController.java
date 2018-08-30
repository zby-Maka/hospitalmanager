package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.Check;
import com.dyhc.hospitalmanager.pojo.Combination;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.pojo.Section;
import com.dyhc.hospitalmanager.service.BasicFunctionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class BasicFunctionController {
    @Autowired
    private BasicFunctionService basicFunctionService;


    /**
     * 添加科室信息
     * @param section
     * @return
     */
    @RequestMapping("addSectionInfo")
    @ResponseBody
    public String addSection(Section section) {
        int result = basicFunctionService.addSectionInfo(section);
        return JSON.toJSONString(result);
    }

    /**
     * 添加体检项信息
     * @param check
     * @return
     */
    @RequestMapping("addCheckInfo")
    @ResponseBody
    public String addCheckInfo(Check check){
        int result=basicFunctionService.addCheckInfo(check);
        return JSON.toJSONString(result);
    }


    /**
     * 跟据组合项id查询组合项信息以及下的体检项信息
     * @param combinationId
     * @return
     */
    @RequestMapping("getCombinationAndCheckInfo")
    @ResponseBody
    public String getCombiantionInfoAndCheck(@Param("combinationId") Integer combinationId){
        List<Check> list=basicFunctionService.getCheckByCombinationId(combinationId);
        return JSON.toJSONString(list);
    }

    /**
     * 添加组合项
     * @param combination
     * @param comAncCheckList
     * @return
     */
    @RequestMapping("addCombinationInfo")
    @ResponseBody
    public String addCombination(Combination combination,@RequestParam("comAncCheckList[]") Integer[] comAncCheckList) throws Exception{
        int result=basicFunctionService.addCombinationInfo(combination,comAncCheckList);
        return JSON.toJSONString(result);
    }


    /**
     * 查询科室信息以及下的组合项信息和体检项信息
     * @return
     */
    @RequestMapping("getSecionAndCheckAndCombinationInfo")
    @ResponseBody
    public String getSecionAndCheckAndCombinationInfo(){
        List<Check>list=basicFunctionService.getSectionAndCheckAndCombinationInfo();
        return JSON.toJSONString(list);
    }

    /**
     * 根据查询科室信息以及下的组合项信息和体检项信息
     */
    @RequestMapping("getSecionAndCheckAndCombinationInfoById")
    @ResponseBody
    public String getSecionAndCheckAndCombinationInfoById(@Param("sectionId")Integer sectionId){
        List<Check>list=basicFunctionService.getSectionAndCheckAndCombinationInfoById(sectionId);
        return JSON.toJSONString(list);
    }

    /**
     * 添加套餐项
     * @param pack
     * @param checkList
     * @return
     */
    @RequestMapping("addPackageInfo")
    @ResponseBody
    public String addPackage(Package pack,@RequestParam("sectionandcheckList[]") Integer[] checkList,@RequestParam("sectionandcombinationList[]") Integer[] combinationList){
        int result=basicFunctionService.addPackageInfo(pack,combinationList,checkList);
        return JSON.toJSONString(result);
    }

    /**
     * 查询所有的科室信息及科室下的组合与套餐
     * @return
     */
    @RequestMapping("/getSectionList.do")
    @ResponseBody
    public Object getSectionList(){
        return JSON.toJSONString(basicFunctionService.getSectionList());
    }

}
