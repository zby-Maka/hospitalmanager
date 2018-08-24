package com.dyhc.hospitalmanager;
import com.dyhc.hospitalmanager.pojo.Cost;
import com.dyhc.hospitalmanager.service.CostOfModuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
            System.out.println(costOfModuleService.getPersonInfoByPersonInfoId(1,0));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
