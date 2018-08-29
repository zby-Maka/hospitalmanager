package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.service.PersonalReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 个人预约
 */
@RestController
public class PersonalReservationController {

    @Autowired
    private PersonalReservationService personalReservation;

    /**
     * 根据身份证号查询用户信息表，绑定信息框
     * @param personIdCard 身份证号
     * @return
     */
    @GetMapping("/getPersonInfoByNameAndCard.do")
    public PersonInfo getPersonInfoByNameAndCard(@RequestParam("personIdCard") String personIdCard){
        return personalReservation.getPersonInfoByNameAndCard(personIdCard);
    }

    /**
     * 用户预约
     * @param personInfo 用户信息
     * @param yue 预约时间
     * @return 1成功
     *          -1失败
     *          -2添加用户信息失败
     *          -3添加预约表失败
     *          -4用户选择套餐失败
     *          -5用户选择体检项失败
     *          -6用户选择体检项失败
     */
    @RequestMapping("/UserReservation.do")
    public String UserReservation(PersonInfo personInfo, @RequestParam(value = "yue") String yue){
        return personalReservation.UserReservation(personInfo,yue);
    }


    /**
     * 获取所有体检项组合项以及套餐
     * @return
     */
    @RequestMapping("/getAll.do")
    public String getAll(){
        List<Check> checks=personalReservation.getAllCheck();
        List<Combination> combinations=personalReservation.getAllCombination();
        List<Package> packages=personalReservation.getPackages();
        List<Object> allMedicals=new ArrayList<Object>();       //定义集合存放数组
        AllMedical allMedical=new AllMedical();     //体检项1
        allMedical.setId(1);
        allMedical.setTitle("体检项");
        allMedical.setAllCheck(checks);
        allMedicals.add(allMedical);
        AllMedical allMedical1=new AllMedical();    //组合项
        allMedical1.setId(2);
        allMedical1.setTitle("组合项");
        allMedical1.setAllCombination(combinations);
        allMedicals.add(allMedical1);
        AllMedical allMedical2=new AllMedical();    //套餐项
        allMedical2.setId(3);
        allMedical2.setTitle("套餐项");
        allMedical2.setAllPackage(packages);
        allMedicals.add(allMedical2);
        return JSON.toJSONString(allMedicals);
    }



    /**
     * 获取所有的检查项
     * @return
     */
    @GetMapping("/ExhibitionAllCheck.do")
    public List<Check> getAllCheck(){
        return personalReservation.getAllCheck();
    }

    /**
     * 获取所有组合项
     * @return
     */
    @GetMapping("/ExhibitionAllCombination.do")
    public List<Combination> getAllCombination(){
        return personalReservation.getAllCombination();
    }

    /**
     * 获取所有套餐
     * @return
     */
    @GetMapping("/ExhibitionAllPackages.do")
    public List<Package> getPackages(){
        return personalReservation.getPackages();
    }

    /**
     * 新增用户选择的套餐、组合项、体检项
     * @param physicalExaminationId 体检编号
     * @param packId 所选的套餐项
     * @param comId 所选的组合项
     * @param checkId 所选的体检项
     * @return null
     */
    @PostMapping("/addPersonCheck")
    public Integer addPersonCheck(@RequestParam("physicalExaminationId") String physicalExaminationId,
                                  @RequestParam("packId[]") Integer[] packId,
                                  @RequestParam("comId[]") Integer[] comId,
                                  @RequestParam("checkId[]") Integer[] checkId){
        return personalReservation.addPersonCheck(physicalExaminationId,packId,comId,checkId);
    }

    @RequestMapping("listDate")
    @ResponseBody
    public Object listDate(){
        return personalReservation.listDate();
    }

    /**
     * 获取该组合项下的所有体检项
     * @param comId 组合项Id
     * @return
     */
    @GetMapping("/getComCheck")
    public List<Check> getComCheck(Integer comId) {
         return personalReservation.getComCheck(comId);
    }

    /**
     * 获取该套餐项下的所有体检项
     * @param packId 套餐id
     * @return
     */
    @GetMapping("/getPackCheck")
    public Package getPackCheck(Integer packId) {
        return personalReservation.getPackCheck(packId);
    }
}
