package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CompanyInfoMapper;
import com.dyhc.hospitalmanager.dao.GroupMapper;
import com.dyhc.hospitalmanager.dao.PersonInfoMapper;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.service.UnitReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UnitReservationServiceImpl implements UnitReservationService {
    private Logger logger= LoggerFactory.getLogger(UnitReservationService.class);
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Autowired
    private CompanyInfoMapper companyInfoMapper;
    @Autowired
    private GroupMapper groupMapper;


    /**
     * 根据单位名称查询单位表
     * @param companyName 单位名称
     * @return
     */
    @Override
    public CompanyInfo showCompanyInfo(String companyName) {
        CompanyInfo companyInfo = null;
        try{
            companyInfo = companyInfoMapper.showCompanyInfo(companyName);
        }catch (Exception e){
            logger.error("查询单位信息失败");
            e.printStackTrace();
        }
        return companyInfo;
    }

    /**
     *  核实公司信息
     *  如果不对进行修改
     * @param companyInfo
     * @return
     */
    @Override
    public Integer updCompanyInfo(CompanyInfo companyInfo) {
        Integer result = 0;
        try{
            result = companyInfoMapper.updCompanyInfo(companyInfo);
        }catch (Exception e){
            logger.error("修改公司信息失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     *  没有进行添加公司信息
     * @param companyInfo
     * @return
     */
    @Override
    public Integer addCompanyInfo(CompanyInfo companyInfo) {
        Integer result = 0;
        try{
            result = companyInfoMapper.addCompanyInfo(companyInfo);
        }catch (Exception e){
            logger.error("添加公司信息失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     *  添加单位分组以及人员信息以及人员信息所属的分组信息
     * @param group 单位分组
     * @param personInfos 人员信息集合
     * @return
     */
    @Transactional
    @Override
    public Integer addGroupAndPersonInfo(Group group, List<PersonInfo> personInfos) {
        Integer groupResult = 0;
        Integer personResult = 0;
        try{
            //执行添加分组单位信息
            groupResult = groupMapper.addGroupInfo(group);
            System.out.println("添加的分组id:"+group.getGroupId());
            if(groupResult > 0){
                //执行添加人员信息
                for(int i =0; i<personInfos.size();i++){
                    //通过身份证号判断人员是否存在
                    System.out.println("身份证:"+personInfos.get(i).getPersonIdCard());
                    PersonInfo personInfo = personInfoMapper.findPersonInfoPersonIdCard(personInfos.get(i).getPersonIdCard());
                    if(personInfo == null){
                        //不存在人员信息进行添加
                        personInfos.get(i).setGroupId(group.getGroupId());
                        personResult = personInfoMapper.addPersonInfo(personInfos.get(i));
                    }
                }
            }
        }catch(Exception e){
            logger.error("添加分组以及人员信息失败");
            e.printStackTrace();

        }
        return personResult;
    }


}