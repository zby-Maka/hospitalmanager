package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.*;
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
    @Autowired
    private PackageMapper packageMapper;


    /**
     * 根据单位名称查询单位表
     * 如果不存在 进行添加单位信息 addCompanyInfo()
     * 如果存在显示单位信息进行核实 , 如果公司信息不正确 执行公司信息修改updCompanyInfo()
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
     *  添加单位分组以及人员信息
     *  以及人员信息所属的分组信息
     *  并且添加人员信息的时候进行
     *  判断这个人是否存在 如果存在就不对这个人进行添加
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
            if(groupResult > 0 && personInfos.size() >0){
                //执行添加人员信息
                for(int i =0; i<personInfos.size();i++){
                    //通过身份证号判断人员是否存在
                    System.out.println("身份证:"+personInfos.get(i).getPersonIdCard());
                    PersonInfo personInfo = personInfoMapper.findPersonInfoPersonIdCard(personInfos.get(i).getPersonIdCard());
                    if(personInfo == null){
                        //不存在人员信息进行添加
                        personInfos.get(i).setGroupId(group.getGroupId());
                        personInfos.get(i).setPersonType("单位");
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

    /**
     * 显示所有套餐信息
     * @return
     */
    public List<Package> showPackage(){
        List<Package> list = null;
        try {
            list = packageMapper.showAllPackage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询所有的单位信息
     * @return
     */
    @Override
    public List<CompanyInfo> showAllCompanyInfo() {
        try {
            List<CompanyInfo> list = companyInfoMapper.showAllCompanyInfo();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据单位id查询单位分组信息
     * @param companyId
     * @return
     */
    @Override
    public List<Group> groupListByCompanyId(Integer companyId) {
        List<Group> list = null;
        try {
            list = groupMapper.groupListByCompanyId(companyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public CompanyInfo showCompanyInfoById(Integer companyId) {
        try {
            return companyInfoMapper.showCompanyInfoById(companyId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PersonInfo findPersonInfoPersonIdCard(String personIdCard) {
        try {
            return personInfoMapper.findPersonInfoPersonIdCard(personIdCard);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Autowired
    private GuideMapper guideMapper;
    @Override
    public int getPackageId(String personIdCard) {
        try {
            return guideMapper.getPackageId(personIdCard);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Check> listCheckId(Integer packageId) {
        try {
            return guideMapper.listCheckId(packageId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer updIsDel(Integer companyId, Integer isDelete) {
        try {
            return companyInfoMapper.updIsDel(companyId,isDelete);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Group showGroupDetails(Integer groupId) {
        try {
            return groupMapper.showGroupDetails(groupId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer updGroup(Integer isDelete,Integer groupId) {
        try {
            return groupMapper.updGroup(isDelete,groupId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Group selectByGroupName(String groupName) {
        Group g = null;
        try {
           g = groupMapper.selectByGroupName(groupName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return g;
    }

}
