package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.Check;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.pojo.PhysicalExamination;
import com.dyhc.hospitalmanager.service.CheckService;
import com.dyhc.hospitalmanager.service.PersonalReservationService;
import com.dyhc.hospitalmanager.service.UnitReservationService;
import com.dyhc.hospitalmanager.util.BarCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 打印指引单
 */
@Controller
public class GuideListController {

    @Autowired
    private CheckService checkService;
    @Autowired
    private UnitReservationService unitReservationService;
    /**
     * 根据体检编号查询体检信息
     * @param physicalExaminationId
     * @return
     */
    @RequestMapping("selectByPhysicalExaminationId.do")
    @ResponseBody
    public String selectByPhysicalExaminationId(@RequestParam("physicalExaminationId") String physicalExaminationId){
        PhysicalExamination list = checkService.selectPhysical(physicalExaminationId);
        Integer result = 0;
        if (list != null ){
            result = 1;
        }
        return JSON.toJSONString(result);
    }

    /**
     * 根据体检编号查看人员信息
     * @param physicalExaminationId
     * @return
     */
    @RequestMapping("/selectInfoByselectByPhysicalExaminationId.do")
    @ResponseBody
    public String selectInfoByselectByPhysicalExaminationId(@RequestParam("physicalExaminationId") String physicalExaminationId){
        List<PersonInfo> list = checkService.personInfo(physicalExaminationId);
        PersonInfo p = new PersonInfo();
        p.setPersonName(list.get(0).getPersonName());
        p.setPersonSex(list.get(0).getPersonSex());
        p.setPersonAge(list.get(0).getPersonAge());
        p.setPersonTelephone(list.get(0).getPersonTelephone());
        p.setPersonType(list.get(0).getPersonType());
        p.setPersonBirthday(list.get(0).getPersonBirthday());
        //显示条形码
        BarCodeUtil.generateFile(physicalExaminationId);
        return JSON.toJSONString(p);
    }

    /**
     * 根据身份证号查看人员信息进行判断
     * @param
     * @return
     */
    @RequestMapping("/personIdCard.do")
    @ResponseBody
    public String personIdCard(@RequestParam("personIdCard") String personIdCard){
        PersonInfo list = unitReservationService.findPersonInfoPersonIdCard(personIdCard);
        Integer result = 0;
        if(list != null){
            result = 1;
        }
        return JSON.toJSONString(result);
    }


    /**
     * 根据身份证号查看人员信息
     * @param
     * @return
     */
    @RequestMapping("/selectInfoByselectByPersonIdCard.do")
    @ResponseBody
    public String selectInfoByselectByPersonIdCard(@RequestParam("personIdCard") String personIdCard){
        PersonInfo list = unitReservationService.findPersonInfoPersonIdCard(personIdCard);

        //显示条形码
        BarCodeUtil.generateFile(list.getPersonIdCard());
        return JSON.toJSONString(list);
    }




    /**
     *  根据体检编号查询用户信息
     * @param physicalExaminationId
     * @return
     */
    @RequestMapping("/showCheckedDetail.do")
    @ResponseBody
    public String showCheckedDetail(@RequestParam("physicalExaminationId") String physicalExaminationId){
        List<Check> lsit = checkService.showListCheckLwr(physicalExaminationId);
        System.out.println("体检信息:"+lsit.size());
        return JSON.toJSONString(lsit);
    }




    @Autowired
    private PersonalReservationService personalReservationService;
    /**
     *  根据身份证号查询套餐信息
     * @param
     * @return
     */
    @RequestMapping("/showPackageId.do")
    @ResponseBody
    public String showPackageId(@RequestParam("personIdCard") String personIdCard){
       int packageId = unitReservationService.getPackageId(personIdCard);
        System.out.println(packageId);
        List<Check> list = null;
        try {
            list = unitReservationService.listCheckId(packageId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(list);
    }
}
