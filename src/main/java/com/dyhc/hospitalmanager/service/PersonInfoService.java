package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.PersonInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonInfoService {
    /**
     * 根据体检编号查询人员信息
     * @return
     */
    List<PersonInfo> getPersonBypeacId(@Param("peacId")String peacId);
}
