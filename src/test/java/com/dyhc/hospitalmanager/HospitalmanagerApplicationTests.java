package com.dyhc.hospitalmanager;

import com.dyhc.hospitalmanager.pojo.CheckResult;
import com.dyhc.hospitalmanager.pojo.MedicalEvents;
import com.dyhc.hospitalmanager.service.SectionService;
import com.dyhc.hospitalmanager.dao.*;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.service.UnitReservationService;
import com.dyhc.hospitalmanager.pojo.Cost;
import com.dyhc.hospitalmanager.service.CostOfModuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalmanagerApplicationTests {
    @Autowired
    private SectionService sectionService;
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
    @Autowired
    private CostOfModuleService costOfModuleService;

    /**
     * 收费/退费
     * physicalStatu收费/退费：0/1
     */
    @Test
    public void contextLoads() {
        test01();
       // test20();
        //test21();
//        addCompanyInfo();
    }
    //科室是检查的时候查询检查结果和建议
//     public void test20(){
//         Map<String,Object> map=null;
//         try {
//             map =sectionService.getCheckResultAndProposed(1,2,1);
//             System.out.println(map.get("list"));
//             System.out.println(map.get("list1"));
//         }catch (Exception e){
//             e.printStackTrace();
//         }
//         }

    /**
     *  根据姓名和身份证查询用户信息
     * @return
     */
    public void test01(){
        try {
            List<PersonInfo> info = personInfoMapper.findPersonInfos("李文荣","141024199703260019");
            System.out.println(info.size());
        }catch (Exception e) {
            e.printStackTrace();

        }
    }


//    /**
//     * 判断是检查还是检验进行相应的添加操作
//     */
//    public void test21() {
//             CheckResult checkResult = new CheckResult();
//             checkResult.setPhysicalExaminationId("2018010102");
//             MedicalEvents medicalEvents = new MedicalEvents();
//             medicalEvents.setEventsName("AD");
//             Integer a = 0;
//             try {
//                 a = sectionService.addCheckResultAndMedicalEvent(checkResult, medicalEvents, 2);
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
    /**
     *  根据单位名称查询单位表
     * @return
     */
    public void test04(){
        try {
            Cost cost = new Cost();
            cost.setCostType("收费");
            cost.setHealthExaminationId("2018010103");
            cost.setCostAmount(new BigDecimal(200.00));
            /*System.out.println(costOfModuleService.addCost(cost,0));*/
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
     * 添加单位信息
     * @return
     */
    public void test07(){
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setCompanyName("白文鑫公司");
        companyInfo.setSpellCode("lwrgs");
        companyInfo.setCompanyPrincipal("白文鑫");
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
     * 修改单位信息
     */
    public void test08(){
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setCompanyName("白文鑫公司");
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
        if(a>0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }

    }


    /**
     * 测试根据公司名称查询公司信息
     */
    public void showCompanyInfo(){
        CompanyInfo companyInfo = unitReservationService.showCompanyInfo("北大青鸟");
        System.out.println("公司名称是:"+companyInfo.getCompanyName());
    }


    /**
     * 核实公司信息进行修改
     */
    public void updCompanyInfo(){
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setCompanyName("白文鑫公司2");
        companyInfo.setCompanyId(5);
        try {
            Integer info = unitReservationService.updCompanyInfo(companyInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加公司信息
     */
    public void addCompanyInfo(){
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setCompanyName("杜晓宇公司22");
        companyInfo.setSpellCode("lwrgs");
        companyInfo.setCompanyPrincipal("白文鑫");
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
