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

    /**
     * 根据体检编号和手机号进行查询
     * @param physical_examination_id
     * @param person_telphone
     * @return
     */
    PersonInfo getPersonInfoByIdAndPhone(@Param("physical_examination_id")String physical_examination_id,@Param("person_telphone")String person_telphone);
}
