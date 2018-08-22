package com.dyhc.hospitalmanager;


import com.dyhc.hospitalmanager.dao.*;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.pojo.Package;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalmanagerApplicationTests {

    @Test
    public void contextLoads() {
        test02();
    }

    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Autowired
    private PackageMapper packageMapper;
    @Autowired
    private CompanyInfoMapper companyInfoMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private MedicalEventsMapper medicalEventsMapper;
    public void test01(){
        try {
            List<PersonInfo> info = personInfoMapper.findPersonInfos("李文荣","");
            System.out.println(info.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public void test03(){
        try {
            List<Package> list = packageMapper.showAllPackage();
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test04(){
        try {
            CompanyInfo list = companyInfoMapper.showCompanyInfo("北大青鸟");
            System.out.println(list.getCompanyName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test05(){
        try {
            CompanyInfo list = companyInfoMapper.showCompanyInfo("北大青鸟");
            System.out.println(list.getCompanyName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        Integer info = companyInfoMapper.addCompanyInfo(companyInfo);
    }

    public void test08(){
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setCompanyName("李文荣公司1");
        companyInfo.setCompanyId(5);
        Integer info = companyInfoMapper.updCompanyInfo(companyInfo);
    }

    public void test09(){
        MedicalEvents medicalEvents  = new MedicalEvents();
        medicalEvents.setEventsName("aaa");
        try {
            Integer a = medicalEventsMapper.addMedicalEvent(medicalEvents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
