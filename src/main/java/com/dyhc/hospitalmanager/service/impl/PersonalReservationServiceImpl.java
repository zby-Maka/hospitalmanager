package com.dyhc.hospitalmanager.service.impl;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.dao.*;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.service.PersonalReservationService;
import com.dyhc.hospitalmanager.util.GetFetureDate;
import com.dyhc.hospitalmanager.util.MessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PersonalReservationServiceImpl implements PersonalReservationService {

    private Logger logger = LoggerFactory.getLogger(PersonalReservationServiceImpl.class);;

    //人员信息表Mapper
    @Autowired
    private PersonInfoMapper personInfoMapper;
    //体检表Mapper
    @Autowired
    private PhysicalExaminationMapper physicalExaminationMapper;
    //体检项Mapper
    @Autowired
    private CheckMapper checkMapper;
    //组合项Mapper
    @Autowired
    private CombinationMapper combinationMapper;
    //套餐Mapper
    @Autowired
    private PackageMapper packageMapper;
    //用户和套餐项的关系Mapper
    @Autowired
    private PhysicalExaminationAndPackageMapper physicalExaminationAndPackageMapper;
    //用户和组合项的关系Mapper
    @Autowired
    private PhysicalExaminationAndCombinationMapper physicalExaminationAndCombinationMapper;
    //用户和体检项的关系Mapper
    @Autowired
    private PhysicalExaminationAndCheckMapper physicalExaminationAndCheckMapper;
    //组合项和体检项的关系Mapper
    @Autowired
    private CombinationAndCheckMapper combinationAndCheckMapper;
    @Autowired
    RedisDao redisDao;

    @Autowired
    private MessageProducer messageProducer;

    public Map<String,Object> map=new HashMap<>();


    /**
     * 根据身份证号查询用户信息表
     * @param personIdCard
     * @return
     */
    @Override
    @Transactional
    public PersonInfo getPersonInfoByNameAndCard(String personIdCard){
        PersonInfo personInfo=null;
        try {
            personInfo=personInfoMapper.findPersonInfoPersonIdCard(personIdCard);
            return personInfo;
        } catch (Exception e) {
            logger.error("根据身份证号查询用户表："+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取redis中的所有键值
     * @return
     */
    @RequestMapping("/listDate")
    @ResponseBody
    public Object listDate(){
        List<RedisKeyValue> list=new ArrayList<>();
        for (int i=0;i<7;i++){
            RedisKeyValue redisKeyValue=new RedisKeyValue();
            redisKeyValue.setKey(GetFetureDate.getFetureDate(i));
            String value=redisDao.getValue(redisKeyValue.getKey());
            redisKeyValue.setValue(value);
            list.add(redisKeyValue);
        }
        return JSON.toJSONString(list);
    }

    /**
     * 用户预约
     * @param personInfo 用户信息
     * @param Yudate 预约时间
     * @return 1成功
     *          -1失败
     *          -2添加用户信息失败
     *          -3添加预约表失败
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public String UserReservation(PersonInfo personInfo,String Yudate) {
        Integer result = 0;
        try {
            PersonInfo per=personInfoMapper.findPersonInfoPersonIdCard(personInfo.getPersonIdCard());
            if (per==null) {
                result = personInfoMapper.addPersonInfo(personInfo);
            }else {
                personInfo.setPersonId(per.getPersonId());
                result = personInfoMapper.updPersonInfo(personInfo);
            }
            if (result < 0) {
                //添加(修改)用户信息失败
                logger.error("添加用户信息失败");
                return -2+"";
            }
            PhysicalExamination physicalExamination = new PhysicalExamination();
            //把日期转换为字符串yyy-MM-dd
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //根据预约日期查询预约日期的最后一位编号
            String physicalExaminationId = physicalExaminationMapper.getPhysicalExaminationOrderByMedicalTime(Yudate);
            if(physicalExaminationId!=null){
                //编号
                String phyNo = physicalExaminationId.substring(8,physicalExaminationId.length());
                //日期
                String phyDate = physicalExaminationId.substring(0,8);
                //生成新的编号
                Integer no = Integer.parseInt(phyNo)+1;
                phyNo = no.toString().length()==1?"0"+no+"":no + "";
                phyNo = phyDate + phyNo;
                physicalExamination.setPhysicalExaminationId(phyNo);
                physicalExamination.setPersonId(personInfo.getPersonId());
                physicalExamination.setMedicalTime(simpleDateFormat.parse(Yudate));
                //给这个人员生成体检编号
                result = physicalExaminationMapper.addPhysicalExaminationInfo(physicalExamination);
                if (result < 0) {
                    //添加用户预约编号失败
                    logger.error("添加用户预约编号失败");
                    return -3+"";
                }
                return phyNo;
            }else {
                String[] date = Yudate.split("-");
                physicalExaminationId=date[0]+date[1]+date[2]+"01";
                physicalExamination.setPhysicalExaminationId(physicalExaminationId);
                physicalExamination.setPersonId(personInfo.getPersonId());
                physicalExamination.setMedicalTime(simpleDateFormat.parse(Yudate));
                //给这个人员生成体检编号
                result = physicalExaminationMapper.addPhysicalExaminationInfo(physicalExamination);
                if (result < 0) {
                    //添加用户预约编号失败
                    logger.error("添加用户预约编号失败");
                    return -3+"";
                }
                return physicalExaminationId;
            }
        } catch (Exception e) {
            logger.error("预约失败，"+e.getMessage());
            e.printStackTrace();
            return -1+"";
        }
    }

//    public Map<String,Object> UserReservation(PersonInfo personInfo,String Yudate){
//        Destination destination = new ActiveMQQueue("reservation");
//        //发送消息
//        messageProducer.sendMessage(destination,personInfo);
//        return map;
//    }

    /**
     * 监听消息
     * @param object
     */
    @JmsListener(destination = "test")
    public void test(Object object){
        //此处接受到消息将redis中的数量减少1进行数据处理
        map.put("测试",object);
    }

    /**
     * 获取所有的检查项
     * @return
     */
    @Override
    @Transactional
    public List<Check> getAllCheck(){
        try {
            return checkMapper.getAllCheckList();
        } catch (Exception e) {
            logger.error("获取所有体检项："+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取所有组合项
     * @return
     */
    @Override
    @Transactional
    public List<Combination> getAllCombination(){
        try {
            return combinationMapper.getAllCombinationList();
        } catch (Exception e) {
            logger.error("获取所有组合项："+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取所有套餐
     * @return
     */
    @Override
    @Transactional
    public List<Package> getPackages() {
        List<Package> packageList = new ArrayList<Package>();
        Package packageCombination=null;
        Package packageCheck=null;
        Package pack = null;
        try {
            List<Integer> packageIdList = packageIdList = packageMapper.getAllPackageId();
            for (Integer packageId:packageIdList) {
                packageCombination =  packageMapper.getPackageCombination(packageId);
                packageCheck =  packageMapper.getPackageCheck(packageId);
                if(packageCombination!=null){
                    if(packageCheck!=null)
                        packageCombination.setPackageCheckList(packageCheck.getPackageCheckList());
                    packageList.add(packageCombination);
                }else {
                    pack= packageMapper.selPackageById(packageId);
                    if(packageCheck!=null)
                        pack.setPackageCheckList(packageCheck.getPackageCheckList());
                    packageList.add(pack);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packageList;
    }

    /**
     * 新增用户选择的套餐、组合项、体检项
     * @param physicalExaminationId 体检编号
     * @param packId 所选的套餐项
     * @param comId 所选的组合项
     * @param checkId 所选的体检项
     * @return null
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer addPersonCheck(String physicalExaminationId,Integer[] packId,Integer[] comId,Integer[] checkId){
        try {
            physicalExaminationAndPackageMapper.addBatchPhyAndPackage(physicalExaminationId,packId);
            physicalExaminationAndCombinationMapper.addBatchPhysicalExaminationAndCombination(physicalExaminationId,comId);
            physicalExaminationAndCheckMapper.addBatchPhysicalExaminationAndCheck(physicalExaminationId,checkId);
        } catch (Exception e) {
            logger.error("用户选择套餐、组合项、体检项："+e.getMessage());
            e.printStackTrace();
            return null;
        }
        return 1;
    }

    /**
     * 获取该组合项下的所有体检项
     * @param comId 组合项Id
     * @return
     */
    @Override
    public List<Check> getComCheck(Integer comId) {
        try {
            return combinationAndCheckMapper.getCheckByCombinationId(comId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取该组合项下的所有体检项:"+e.getMessage());
            return null;
        }
    }

    /**
     * 获取该套餐项下的所有体检项
     * @param packId 套餐id
     * @return
     */
    @Override
    public Package getPackCheck(Integer packId) {
        Package packageCombination=null;
        Package packageCheck=null;
        Package pack = null;
        try {
            packageCombination =  packageMapper.getPackageCombination(packId);
            packageCheck =  packageMapper.getPackageCheck(packId);
            if(packageCombination!=null){
                if(packageCheck!=null)
                    packageCombination.setPackageCheckList(packageCheck.getPackageCheckList());
            }else {
                pack= packageMapper.selPackageById(packId);
                if(packageCheck!=null)
                    pack.setPackageCheckList(packageCheck.getPackageCheckList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packageCombination;
    }
}