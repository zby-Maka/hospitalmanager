package com.dyhc.hospitalmanager;


import com.dyhc.hospitalmanager.dao.*;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.service.UnitReservationService;
import com.dyhc.hospitalmanager.pojo.Cost;
import com.dyhc.hospitalmanager.service.CostOfModuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalmanagerApplicationTests {

    @Autowired
    private CostOfModuleService costOfModuleService;

    /**
     * 收费/退费
     * physicalStatu收费/退费：0/1
     */
    @Test
    public void contextLoads() {
        addCompanyInfo();
    }

    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Autowired
    private PhysicalExaminationMapper physicalExaminationMapper;
    @Autowired
    private CheckMapper checkMapper;
    @Autowired
    private CheckResultMapper checkResultMapper;

    @Autowired
    private PackageMapper packageMapper;
    @Autowired
    private CompanyInfoMapper companyInfoMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private MedicalEventsMapper medicalEventsMapper;
    @Autowired
    private PhysicalExaminationAndPackageMapper physicalExaminationAndPackageMapper;
    @Autowired
    private UnitReservationService unitReservationService;
    /**
     *  李文荣
     *  根据姓名和身份证查询用户信息
     * @return
     */
    public void test01(){
        try {
            List<PersonInfo> info = personInfoMapper.findPersonInfos("李文荣","141024199703260019");
            System.out.println(info.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 李文荣
     * 添加用户信息
     * @return
     */
    public void test02(){
        try {
            String str = "2013-06-09";
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            System.out.println(d);
            PersonInfo personInfo = new PersonInfo();
            personInfo.setPersonName("测试111");
            personInfo.setPersonAge(10);
            personInfo.setPersonBirthday(new Date());
            Integer info = personInfoMapper.addPersonInfo(personInfo);
            System.out.println(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 李文荣
     * 获取所有套餐
     * @return
     */
    public void test03(){
        try {
            List<Package> list = packageMapper.showAllPackage();
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 李文荣
     *  根据单位名称查询单位表
     * @return
     */
    public void test04(){
        try {
            Cost cost = new Cost();
            cost.setCostType("收费");
            cost.setHealthExaminationId("2018010103");
            cost.setCostAmount(new BigDecimal(200.00));
            System.out.println(costOfModuleService.addCost(cost,0));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据Id查询人员信息
     * personld:人员id
     * physicalStatu收费/退费：0/1
     */
    @Test
    public void contextLoads01() {
        try {
            CompanyInfo list = companyInfoMapper.showCompanyInfo("北大青鸟");
            System.out.println(list.getCompanyName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * lwr
     * 添加单位分组信息
     */
    public void test06(){
        try {
            Group group = new Group();
            group.setGroupName("测试");
            group.setCompanyId(1);
            group.setTermIsMarry("未婚");
            group.setTermSex("男");
            group.setTermAgeFloor(12);
            group.setTermAgeCeil(20);
            group.setPackageId(1);
            group.setIsDelete(1);
            Integer list = groupMapper.addGroupInfo(group);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 李文荣
     * 添加单位信息
     * @return
     */
    public void test07(){
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setCompanyName("李文荣公司");
        companyInfo.setSpellCode("lwrgs");
        companyInfo.setCompanyPrincipal("李文荣");
        companyInfo.setTelephone("13753524527");
        companyInfo.setPostalCode("031400");
        companyInfo.setAddress("山西霍州");
        companyInfo.setBankName("中国银行");
        companyInfo.setBankNumber("134123412341341234");
        companyInfo.setCompanyNature("国企");
        companyInfo.setAuthorizedStrength(200);
        companyInfo.setIsDelete(1);
        try {
            Integer info = companyInfoMapper.addCompanyInfo(companyInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 李文荣
     * 修改单位信息
     */
    public void test08(){
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setCompanyName("李文荣公司1");
        companyInfo.setCompanyId(5);
        try {
            Integer info = companyInfoMapper.updCompanyInfo(companyInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test09(){
        MedicalEvents medicalEvents  = new MedicalEvents();
        medicalEvents.setEventsName("aaa");
        try {
            Integer a = medicalEventsMapper.addMedicalEvent(medicalEvents);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void test10(){
        PhysicalExaminationAndPackage physicalExaminationAndPackage = new PhysicalExaminationAndPackage();
        physicalExaminationAndPackage.setPhysicalExaminationId("2018010102");
        physicalExaminationAndPackage.setPackageId(1);
        physicalExaminationAndPackage.setPhysicalStatu(0);
        try {
            Integer a = physicalExaminationAndPackageMapper.addPhyAndPackage(physicalExaminationAndPackage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 李文荣
     * 添加单位分组以及人员信息
     *  以及人员信息所属的分组信息
     *  并且添加人员信息的时候进行
     *  判断这个人是否存在 如果存在就不对这个人进行添加
     */
    public void testGroup(){
        Group group = new Group();
        group.setGroupName("胜利小组");
        group.setCompanyId(1);
        group.setTermIsMarry("未婚");
        group.setTermSex("男");
        group.setTermAgeFloor(12);
        group.setTermAgeCeil(20);
        group.setPackageId(1);
        group.setIsDelete(1);
        List<PersonInfo> per = new ArrayList<>();
        PersonInfo personInfo1 = new PersonInfo();
        personInfo1.setPersonName("测试1");
        personInfo1.setPersonAge(10);
        personInfo1.setPersonIdCard("12345612345613323");
        personInfo1.setPersonBirthday(new Date());
        PersonInfo personInfo2 = new PersonInfo();
        personInfo2.setPersonName("测试a");
        personInfo2.setPersonAge(10);
        personInfo2.setPersonIdCard("123444888896523632");
        personInfo2.setPersonBirthday(new Date());
        PersonInfo personInfo3 = new PersonInfo();
        personInfo3.setPersonName("测试3");
        personInfo3.setPersonAge(10);
        personInfo3.setPersonIdCard("141024155470152205");
        personInfo3.setPersonBirthday(new Date());
        per.add(personInfo1);
        per.add(personInfo2);
        per.add(personInfo3);
        Integer a = unitReservationService.addGroupAndPersonInfo(group,per);

    }


    /**
     * 测试根据公司名称查询公司信息 李文荣
     */
    public void showCompanyInfo(){
        CompanyInfo companyInfo = unitReservationService.showCompanyInfo("北大青鸟");
        System.out.println("公司名称是:"+companyInfo.getCompanyName());
    }


    /**
     * 核实公司信息进行修改 李文荣
     */
    public void updCompanyInfo(){
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setCompanyName("李文荣公司2");
        companyInfo.setCompanyId(5);
        try {
            Integer info = unitReservationService.updCompanyInfo(companyInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加公司信息 李文荣
     */
    public void addCompanyInfo(){
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setCompanyName("刘杰公司22");
        companyInfo.setSpellCode("lwrgs");
        companyInfo.setCompanyPrincipal("李文荣");
        companyInfo.setTelephone("13753524527");
        companyInfo.setPostalCode("031400");
        companyInfo.setAddress("山西霍州");
        companyInfo.setBankName("中国银行");
        companyInfo.setBankNumber("134123412341341234");
        companyInfo.setCompanyNature("国企");
        companyInfo.setAuthorizedStrength(200);
        companyInfo.setIsDelete(1);
        try {
            Integer info = unitReservationService.addCompanyInfo(companyInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
