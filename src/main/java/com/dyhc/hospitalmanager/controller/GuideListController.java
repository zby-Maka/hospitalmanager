package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.Check;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.pojo.PhysicalExamination;
import com.dyhc.hospitalmanager.service.CheckService;
import com.dyhc.hospitalmanager.service.GuideService;
import com.dyhc.hospitalmanager.service.PersonalReservationService;
import com.dyhc.hospitalmanager.service.UnitReservationService;
import com.dyhc.hospitalmanager.util.BarCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private GuideService guideService;
    //体检编号
    private String resultsId;

    public String getResultsId() {
        return resultsId;
    }

    public void setResultsId(String resultsId) {
        this.resultsId = resultsId;
    }

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
        return JSON.toJSONString(lsit);
    }




    @Autowired
    private PersonalReservationService personalReservationService;
    /**
     *  根据身份证号查询套餐信息并且添加各种关系
     * @param
     * @return
     */
    @RequestMapping("/showPackageId.do")
    @ResponseBody
    public String showPackageId(@RequestParam("personIdCard") String personIdCard,@RequestParam("personId") Integer personId,HttpServletRequest request){
        //套餐id
        int packageId = unitReservationService.getPackageId(personIdCard);
        List<Check> list = null;
        Integer[] pac={packageId};
        resultsId = guideService.addRelationPerson(personId,pac,packageId);
        if(resultsId != null){
            System.out.println("添加成功");
        }
        //根据体检编号显示条形码
        BarCodeUtil.generateFile(resultsId);
        HttpSession session=request.getSession();
        System.out.println(resultsId);
        session.setAttribute("resultsId",resultsId);
        try {
            list = unitReservationService.listCheckId(packageId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(list);
    }


    /**
     *
     *
     * 显示体检编号
     * @return
     */
    @RequestMapping("/showResultId.do")
    @ResponseBody
    public String showResultId(){
        return JSON.toJSONString(resultsId);
    }


    /**
     *  根据体检编号判断人员是否已经打印过指引单
     * @param physicalExaminationId
     * @return
     */
    @RequestMapping("/selectStatusByPhysicalExamination.do")
    @ResponseBody
    public String selectStatusByPhysicalExamination(@RequestParam("physicalExaminationId") String physicalExaminationId){
        PhysicalExamination list = guideService.selectStatusByPhysicalExamination(physicalExaminationId);
        return JSON.toJSONString(list);
    }

    /**
     *  修改体检打印状态
     * @param physicalExaminationId
     * @return
     */
    @RequestMapping("/updPhysicalExaminationStatus.do")
    @ResponseBody
    public String updPhysicalExaminationStatus(@RequestParam("physicalExaminationId") String physicalExaminationId){
        Integer result = 0;
        if(guideService.updPhysicalExaminationStatus(physicalExaminationId) > 0){
            result = 1;
        }
        return JSON.toJSONString(result);

    }
}
