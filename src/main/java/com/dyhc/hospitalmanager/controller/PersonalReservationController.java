package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.service.PersonalReservationService;
import com.dyhc.hospitalmanager.util.SendMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

/**
 * 个人预约
 */
@RestController
public class PersonalReservationController {

    @Autowired
    private PersonalReservationService personalReservation;

    private SendMes sendMes = new SendMes();

    /**
     * 根据身份证号查询用户信息表，绑定信息框
     * @param personIdCard 身份证号
     * @return
     */
    @GetMapping("/getPersonInfoByNameAndCard.do")
    public PersonInfo getPersonInfoByNameAndCard(@RequestParam("personIdCard") String personIdCard){
        PersonInfo personInfo=personalReservation.getPersonInfoByNameAndCard(personIdCard);
        if(personInfo==null){
            return new PersonInfo();
        }
        return personInfo;
    }

    /**
     * 获取所有体检项组合项以及套餐
     * @return
     */
    @RequestMapping(value = "/getAll.do")
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
    /*
     * @return 1成功
     *          -1失败
     *          -2添加用户信息失败
     *          -3添加预约表失败
     *          -4用户选择套餐失败
     *          -5用户选择体检项失败
     *          -6用户选择体检项失败
     */
    @RequestMapping(value = "/wxUserReservation.do",method=RequestMethod.POST)
    @ResponseBody
    public String wxUserReservation(@RequestBody JSONObject json){


        JSONArray tjx1=json.getJSONArray("tjx");        //体检项转集合
        Integer[] tjx=null;
        if (tjx1.size()!=0){
            String tjcjson=JSON.toJSONString(tjx1);
            List<Integer> number1=JSONObject.parseArray(tjcjson,Integer.class);
            tjx=new Integer[number1.size()];
            for (int i = 0;i<number1.size();i++){
                tjx[i]=number1.get(i);
            }
        }

        JSONArray zhx1=json.getJSONArray("zhx");        //组合项数组
        Integer[] zhx=null;
        if (zhx1.size()!=0){
            String zhxjson=JSON.toJSONString(zhx1);
            List<Integer> number2=JSONObject.parseArray(zhxjson,Integer.class);
            zhx=new Integer[number2.size()];
            for (int i = 0;i<number2.size();i++){
                zhx[i]=number2.get(i);
            }
        }


        JSONArray pac1=json.getJSONArray("pac");        //套餐
        Integer[] pac = null;
        if (pac1.size()!=0){
            String pacjson=JSON.toJSONString(pac1);
            List<Integer> number3=JSONObject.parseArray(pacjson,Integer.class);
            pac=new Integer[number3.size()];
            for (int i = 0;i<number3.size();i++){
                pac[i]=number3.get(i);
            }
        }


        Object object=json.get("userInfo");
        String jsontext=JSON.toJSONString(object);
        PersonInfo personInfo=JSONObject.parseObject(jsontext,PersonInfo.class);
        String datetime=json.getString("dateTime");
        String num=personalReservation.userReservation(personInfo,datetime,pac,zhx,tjx);
        System.out.println(num);
        return num;
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
    public String UserReservation(PersonInfo personInfo, @RequestParam(value = "yue") String yue,
                                  @RequestParam(value = "packId[]",required = false) Integer[] packId,
                                  @RequestParam(value = "comId[]",required = false) Integer[] comId,
                                  @RequestParam(value = "checkId[]",required = false) Integer[] checkId){
        String result = personalReservation.userReservation(personInfo,yue,packId,comId,checkId);
        return result;
    }



    /**
     * 获取所有的检查项
     * @return
     */
    @GetMapping("/ExhibitionAllCheck.do")
    public List<Check> getAllCheck(){
        System.out.println(JSON.toJSONString(personalReservation.getAllCheck(),true));
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

    @RequestMapping("listDate.do")
    @ResponseBody
    public Object listDate(){
        return personalReservation.listDate();
    }

    /**
     * 获取该组合项下的所有体检项
     * @param comId 组合项Id
     * @return
     */
    @GetMapping("/getComCheck.do")
    public List<Check> getComCheck(Integer comId) {
         return personalReservation.getComCheck(comId);
    }

    /**
     * 获取该套餐项下的所有体检项
     * @param packId 套餐id
     * @return
     */
    @GetMapping("/getPackCheck.do")
    public Package getPackCheck(Integer packId) {
        return personalReservation.getPackCheck(packId);
    }

    @GetMapping("/smg.do")
    public String sendSmg(String phone,String physicalExaminationId){
        return JSON.toJSONString(sendMes.sendMes(phone,physicalExaminationId));
    }
}
