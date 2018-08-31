package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.*;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.service.BasicFunctionService;
import com.dyhc.hospitalmanager.service.CostOfModuleService;
import javafx.scene.control.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CostOfModuleServiceImpl implements CostOfModuleService {

    private Logger logger= LoggerFactory.getLogger(BasicFunctionService.class);
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Autowired
    private PhysicalExaminationMapper physicalExaminationMapper;
    @Autowired
    private CheckMapper checkMapper;
    @Autowired
    private CostMapper costMapper;
    @Autowired
    private CostDetailMapper costDetailMapper;

    /**
     * 根据体检编号查询人员信息及其体检信息
     * @param physical_examination_id
     * @return
     */
    @Override
    public PersonInfo getPersonInfoByPersonInfoId(String physical_examination_id,Integer physicalStatu) {
        PersonInfo personInfo = null ;
        try {
            personInfo = personInfoMapper.getPersonInfoByPhysical_Examination_Id(physical_examination_id);
            personInfo.setCheckList(checkMapper.getCheckByPhysicalExaminationIdList(physical_examination_id,physicalStatu));
            return personInfo;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("根据Id查询人员信息失败");
            return null;
        }
    }

    /**
     * 新增费用信息
     * @param physical_examination_id
     * @param physicalStatu
     * @return
     */
    @Override
    public Integer addCost(String physical_examination_id,BigDecimal aggregate,Integer physicalStatu) {
        try {
            Cost cost = new Cost();
            if (physicalStatu==1){
                cost.setCostType("退费");
            }else{
                cost.setCostType("收费");
            }
            cost.setHealthExaminationId(physical_examination_id);
            cost.setCostAmount(aggregate);
            List<Check> list = checkMapper.getCheckByPhysicalExaminationIdList(cost.getHealthExaminationId(),physicalStatu);
            Integer costId = costMapper.addCost(cost);
            Integer cId = costMapper.getCostIdByPhysical_Examination_IdAndCostType(cost.getHealthExaminationId(),cost.getCostType());
            System.out.println(cId);
            if (costId>0){
                for (Check check : list){
                    CostDetail costDetail = new CostDetail();
                    costDetail.setCostId(cId);
                    costDetail.setCostDetailPrice(check.getCheckPrice());
                    costDetail.setCheckId(check.getCheckId());
                    this.addCostDetail(costDetail);
                }
                return costId;
            }else{
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("新增费用信息失败");
            return 0;
        }
    }

    /**
     * 添加费用明细信息
     * @param costDetail
     * @return
     */
    @Override
    public Integer addCostDetail(CostDetail costDetail) {
        try {
            Integer result = costDetailMapper.addCostDetail(costDetail);
            if (result>0){
                return result;
            }else{
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("添加费用明细信息失败");
            return 0;
        }
    }

    /**
     * 根据人员id查询该体检人是否已缴费/是否已退费
     * @param personId
     * @return
     */
    @Override
    public String getCostTypeByPersonId(Integer personId,String costTypes) {
        try {
            String physical_examination_id = physicalExaminationMapper.getPhysicalExaminationByPersonId(personId);
            String costType = costMapper.getCostTypeByPhysical_Examination_Id(physical_examination_id,costTypes);
            if (costType!=""){
                return costType;
            }else{
                return "";
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("根据人员id查询该体检人是否已缴费/是否已退费失败");
            return "";
        }
    }
}
