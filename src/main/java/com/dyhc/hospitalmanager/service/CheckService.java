package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.Check;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CheckService {

    /**
     * 查询所有的体检项
     * @return
     */
    List<Check> getAllCheckList();
    /**
     * 根据体检编号，查询人员体检项
     * @param physicalExaminationId
     * @return
     * @throws Exception
     */
    List<Check>  getCheckList(String  physicalExaminationId);

    /**
     * 根据体检编号查询体检信息
     * @param peacId
     * @return
     */
    List<PersonInfo> personInfo(String peacId);
}
