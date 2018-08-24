package com.dyhc.hospitalmanager;



import com.alibaba.druid.sql.ast.statement.SQLForeignKeyImpl;
import com.dyhc.hospitalmanager.pojo.CheckResult;
import com.dyhc.hospitalmanager.pojo.MedicalEvents;
import com.dyhc.hospitalmanager.service.SectionService;
import com.dyhc.hospitalmanager.service.SectionTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalmanagerApplicationTests {
    @Autowired
    private SectionService sectionService;
    @Test
    public void contextLoads() {
        test9();
        //test10();
    }
    //科室是检查的时候查询检查结果合建议
     public void test9(){
         Map<String,Object> map=null;
        try {
            map =sectionService.getCheckResultAndProposed(1,2,1);
            System.out.println(map.get("list"));
            System.out.println(map.get("list1"));
        }catch (Exception e){
             e.printStackTrace();
        }

     }


    //判断是检查还是检验进行相应的添加操作
    public void test10()  {
        CheckResult checkResult=new CheckResult();
        checkResult.setPhysicalExaminationId("2018010102");
        MedicalEvents medicalEvents=new MedicalEvents();
        medicalEvents.setEventsName("AD");
        Integer a=0;
        try{
            a=sectionService.addCheckResultAndMedicalEvent(checkResult,medicalEvents,2);
        }catch (Exception e){
           e.printStackTrace();
        }
        if(a>0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }


    }






}
