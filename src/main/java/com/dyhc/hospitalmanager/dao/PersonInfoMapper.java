package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.pojo.PhysicalExamination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PersonInfoMapper {
    /**
     *  根据姓名和身份证查询用户信息
     * @param personName 用户姓名
     * @param personIdCard 身份证号
     * @return
     */
    List<PersonInfo> findPersonInfos(@Param("personName") String personName, @Param("personIdCard") String personIdCard)throws  Exception;

    /**
     * 添加用户信息
     * @param personInfo 用户信息
     * @return
     */
    Integer addPersonInfo(PersonInfo personInfo)throws  Exception;

    /**
     * 根据手机号查询人员信息
     * @param personTelephone 手机号属性
     * @return 返回一个人员信息对象
     */
    PersonInfo getPersonInfoByPersonTelephone(@Param("personTelephone")String personTelephone)throws  Exception;

    /**
     * 修改用户
     * @param personInfo 用户信息
     * @return
     */
    Integer updPersonInfo(PersonInfo personInfo)throws  Exception;

    /**
     *  根据用户身份证号码查询用户信息
     * @param personIdCard 身份证号码
     * @return
     */
    PersonInfo findPersonInfoPersonIdCard(@Param("personIdCard") String personIdCard)throws  Exception;

    /**
     * 根据体检编号查询人员信息
     * @param physical_examination_id
     * @return
     */
    PersonInfo getPersonInfoByPhysical_Examination_Id(@Param("physical_examination_id")String physical_examination_id)throws  Exception;
    /**
     * 根据体检编号和手机号查询
     * @param physical_examination_id
     * @param person_telphone
     * @return
     */
    PersonInfo getPersonInfoByIdAndPhone(@Param("physical_examination_id")String physical_examination_id,@Param("person_telphone")String person_telphone);


    /**
     * 根据体检编号查询人员信息
     * @return
     */
    List<PersonInfo> getPersonBypeacId(@Param("peacId")String peacId)throws Exception;

    List<PersonInfo> getPersonInfoListByGroupId(@Param("groupId") Integer groupId)throws Exception;

}
