package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.PersonInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PersonInfoMapper {
    /**
     *  李文荣
     *  根据姓名和身份证查询用户信息
     * @param personName 用户姓名
     * @param personIdCard 身份证号
     * @return
     */
    List<PersonInfo> findPersonInfos(@Param("personName") String personName, @Param("personIdCard") String personIdCard);

}
