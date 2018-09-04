package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.pojo.Package;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 单位预约模块
 */
@Mapper
@Repository
public interface UnitReservationService {


    /**
     *  根据单位名称查询单位表
     * @param companyName 单位名称
     * @return
     */
    CompanyInfo showCompanyInfo(String companyName);

    /**
     * 修改单位信息
     * @param companyInfo
     * @return
     */
    Integer updCompanyInfo(CompanyInfo companyInfo);

    /**
     * 添加单位信息
     * @param companyInfo
     * @return
     */
    Integer addCompanyInfo(CompanyInfo companyInfo);

    /**
     * 添加单位分组以及人员信息以及人员信息所属的分组信息
     * @param group 单位分组
     * @param personInfos 人员信息集合
     * @return
     */
    Integer addGroupAndPersonInfo(Group group,List<PersonInfo> personInfos);

    /**
     * 查询所有套餐信息
     * @return
     */
    List<Package> showPackage();

    List<CompanyInfo> showAllCompanyInfo();

    List<Group> groupListByCompanyId(@Param("companyId") Integer companyId);

    CompanyInfo showCompanyInfoById(Integer companyId);

    /**
     *  根据用户身份证号码查询用户信息
     * @param personIdCard 身份证号码
     * @return
     */
    PersonInfo findPersonInfoPersonIdCard(@Param("personIdCard") String personIdCard);

    /**
     * 根据身份证号查询套餐id
     * @param personIdCard
     * @return
     */
    int getPackageId(@Param("personIdCard")String personIdCard);

    /**
     * 根据套餐id显示所有的体检信息
     * @param personIdCard
     * @return
     * @throws Exception
     */
    List<Check> listCheckId(@Param("personIdCard")Integer personIdCard)throws Exception;

    Integer updIsDel(@Param("companyId") Integer companyId,@Param("isDelete") Integer isDelete);

}
