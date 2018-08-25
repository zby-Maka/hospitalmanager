package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.Check;
import com.dyhc.hospitalmanager.pojo.Combination;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import java.util.Date;
import java.util.List;

/**
 * 个人预约业务
 */
public interface PersonalReservationService {

    /**
     * 根据身份证号查询用户信息表
     * @param personIdCard
     * @return
     */
    PersonInfo getPersonInfoByNameAndCard(String personIdCard);

    /**
     * 用户预约
     * @param personInfo 用户信息
     * @param Yudate 预约时间
     * @return 1成功
     *          -1失败
     *          -2添加用户信息失败
     *          -3添加预约表失败
     */
    int UserReservation(PersonInfo personInfo,Date Yudate);

    /**
     * 获取所有的检查项
     * @return
     */
    List<Check> getAllCheck();

    /**
     * 获取所有组合项
     * @return
     */
    List<Combination> getAllCombination();

    /**
     * 获取所有套餐
     * @return
     */
    List<com.dyhc.hospitalmanager.pojo.Package> getPackages();

    /**
     * 新增用户选择的套餐、组合项、体检项
     * @param physicalExaminationId 体检编号
     * @param packId 所选的套餐项
     * @param comId 所选的组合项
     * @param checkId 所选的体检项
     * @return null
     */
    Integer addPersonCheck(String physicalExaminationId,Integer[] packId,Integer[] comId,Integer[] checkId);
}