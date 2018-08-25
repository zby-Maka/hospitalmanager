package com.dyhc.hospitalmanager;

import com.dyhc.hospitalmanager.pojo.Check;
import com.dyhc.hospitalmanager.pojo.Combination;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.service.PersonalReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonalReservationApplicationTests {

    @Autowired
    private PersonalReservationService personalReservation;

    /**
     * 根据身份证号查询用户信息表
     * @return
     */
    @Test
    public void getPersonInfoByNameAndCard(){
        PersonInfo personInfo=personalReservation.getPersonInfoByNameAndCard("141024199703260019");
        System.out.println(personInfo.getPersonName());
    }

    /**
     * 用户预约
     *          -1失败
     *          -2添加用户信息失败
     *          -3添加预约表失败
     */
    @Test
    public void addPersonInfo() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setPersonIdCard("141024199703260019");
        Integer result = personalReservation.UserReservation(personInfo,new Date());
        System.out.println(result);
    }

    /**
     * 获取所有的检查项
     * @return
     */
    @Test
    public void getAllCheck(){
        List<Check> checkList =  personalReservation.getAllCheck();
        for (Check c:checkList) {
            System.out.println(c.getCheckName());
        }
    }

    /**
     * 获取所有组合项
     * @return
     */
    @Test
    public void getAllCombination(){
        List<Combination> CombinationList =  personalReservation.getAllCombination();
        for (Combination c:CombinationList) {
            System.out.println(c.getCombinationName());
            System.out.println("组合项里有几个体检项："+c.getCombinationCheckList().size());
        }
    }

    /**
     * 获取所有套餐
     * @return
     */
    @Test
    public void getPackages() {
        List<Package> PackageList =  personalReservation.getPackages();
        for (Package p:PackageList) {
            System.out.println(p.getPackageName());
            System.out.println("套餐下的组合项个数："+p.getPackageCombinationList().size());
            System.out.println("套餐下的体检项个数："+p.getPackageCheckList().size());
        }
    }

    /**
     * 新增用户选择的套餐、组合项、体检项
     * @return
     */
    @Test
    public void addPersonCheck(){
        String physicalExaminationId="123";
        Integer[] packId = {1,2};
        Integer[] comId ={1,2};
        Integer[] checkId = {2,2};
        personalReservation.addPersonCheck(physicalExaminationId,packId,comId,checkId);
    }
}
