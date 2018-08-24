package com.dyhc.hospitalmanager;

import com.dyhc.hospitalmanager.dao.CheckResultMapper;
import com.dyhc.hospitalmanager.pojo.CheckResult;
import com.dyhc.hospitalmanager.service.CheckResultService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReoleTest {
    @Resource
    private CheckResultService checkResultService;

    /**住：登录模块：使用页面测试 谢谢
     * 通过体检编号查询总检医生的建议以及结果
     */
    @Test
    public  void getCkeckResult(){
        try {
            List<CheckResult> checkResultList=checkResultService.getCheckResults("2018010101");
            for (CheckResult c:checkResultList) {
                System.out.println(c.getMedicalEvents().getMedicalResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
