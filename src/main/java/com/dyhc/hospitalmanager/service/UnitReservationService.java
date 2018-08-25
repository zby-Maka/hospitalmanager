package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.pojo.Package;
import org.apache.ibatis.annotations.Mapper;
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


}
