package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.*;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.service.CostOfModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CostOfModuleServiceImpl implements CostOfModuleService {

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
     * 根据Id查询人员信息
     * @param personId
     * @return
     */
    @Override
    public PersonInfo getPersonInfoByPersonInfoId(Integer personId,Integer physicalStatu) {
        PersonInfo personInfo = null ;
        try {
            personInfo = personInfoMapper.getPersonInfoByPersonId(personId);
            String physical_examination_id = physicalExaminationMapper.getPhysicalExaminationByPersonId(personInfo.getPersonId());
            personInfo.setCheckList(checkMapper.getCheckByPhysicalExaminationIdList(physical_examination_id,physicalStatu));
            return personInfo;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 新增费用信息
     * @param cost
     * @return
     */
    @Override
    public Integer addCost(Cost cost,Integer physicalStatu) {
        try {
            List<Check> list = checkMapper.getCheckByPhysicalExaminationIdList(cost.getHealthExaminationId(),physicalStatu);
            Integer costId = costMapper.addCost(cost);
            if (costId>0){
                for (Check check : list){
                    CostDetail costDetail = new CostDetail();
                    costDetail.setCostId(costId);
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
            return 0;
        }
    }
}
