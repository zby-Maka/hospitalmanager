package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.*;
import com.dyhc.hospitalmanager.pojo.Check;
import com.dyhc.hospitalmanager.pojo.PhysicalExamination;
import com.dyhc.hospitalmanager.service.GuideService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class GuideServiceImpl implements GuideService {
    private Logger logger = LoggerFactory.getLogger(PersonalReservationServiceImpl.class);
    //体检表Mapper
    @Autowired
    private PhysicalExaminationMapper physicalExaminationMapper;
    //用户和套餐项的关系Mapper
    @Autowired
    private PhysicalExaminationAndPackageMapper physicalExaminationAndPackageMapper;
    //用户和组合项的关系Mapper
    @Autowired
    private PhysicalExaminationAndCombinationMapper physicalExaminationAndCombinationMapper;
    //用户和体检项的关系Mapper
    @Autowired
    private PhysicalExaminationAndCheckMapper physicalExaminationAndCheckMapper;
    @Autowired
    private GuideMapper guideMapper;

    /**
     * 添加单位预约人员与检查项的关系
     *
     * @param personId 人员Id
     * @param packId   套餐id
     * @return
     */
    @Override
    public String addRelationPerson(Integer personId, Integer[] packId,Integer packageId) {
        //自动生成体检编号
        PhysicalExamination physicalExamination = new PhysicalExamination();
        //把日期转换为字符串yyy-MM-dd
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //获取预约日期
        String Yudate = simpleDateFormat.format(new Date());
        //根据预约日期查询预约日期的最后一位编号
        String physicalExaminationId = null;
        Integer result = 0;
        try {
            physicalExaminationId = physicalExaminationMapper.getPhysicalExaminationOrderByMedicalTime(Yudate);
            if (physicalExaminationId != null) {
                //给这个人员生成体检编号
                //编号
                String phyNo = physicalExaminationId.substring(8, physicalExaminationId.length());
                //日期
                String phyDate = physicalExaminationId.substring(0, 8);
                //生成新的编号
                Integer no = Integer.parseInt(phyNo) + 1;
                phyNo = no.toString().length() == 1 ? "0" + no + "" : no + "";
                phyNo = phyDate + phyNo;
                physicalExamination.setPhysicalExaminationId(phyNo);
                physicalExamination.setPersonId(personId);
                physicalExamination.setMedicalTime(simpleDateFormat.parse(Yudate));
                //新增用户与体检表的关系
                result = physicalExaminationMapper.addPhysicalExaminationInfo(physicalExamination);
                physicalExaminationId = phyNo;
                if (result == 0) {
                    //添加用户预约编号失败
                    logger.error("添加用户预约编号失败");
                    return null;
                }
            } else {
                //给这个人员生成体检编号
                String[] date = Yudate.split("-");
                physicalExaminationId = date[0] + date[1] + date[2] + "01";
                physicalExamination.setPhysicalExaminationId(physicalExaminationId);
                physicalExamination.setPersonId(personId);
                physicalExamination.setMedicalTime(simpleDateFormat.parse(Yudate));
                //新增用户与体检表的关系
                result = physicalExaminationMapper.addPhysicalExaminationInfo(physicalExamination);
                if (result == 0) {
                    //添加用户预约编号失败
                    logger.error("添加用户错误");
                    return null;
                }
            }
            System.out.println("体检编号:"+physicalExaminationId);
            //添加体检编号与套餐的关系
            result = physicalExaminationAndPackageMapper.addBatchPhyAndPackage(physicalExaminationId, packId);
            //添加体检编号与体检项的关系
            List<Integer> checkList = new ArrayList<>();

            //根据套餐编号查询套餐下的体检项信息
            List<Check> listCheck  = guideMapper.listCheckId(packageId);
            for(int i =0 ;i<listCheck.size();i++){
                checkList.add(listCheck.get(i).getCheckId());
            }
            result = physicalExaminationAndCheckMapper.addBatchPhysicalExaminationAndCheck(physicalExaminationId, checkList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return physicalExaminationId;
    }
}
