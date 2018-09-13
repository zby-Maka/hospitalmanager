package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.Check;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.pojo.PhysicalExamination;
import org.apache.ibatis.annotations.Param;
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
     * 根据体检编号和手机号查询
     * @param physicalExaminationId
     * @param telephone
     * @return
     * @throws Exception
     */
    List<Check>  getChecks(@Param("physicalExaminationId")String  physicalExaminationId,@Param("telephone")String telephone) throws  Exception;


    /**
     * 根据体检编号查询体检信息
     * @param peacId
     * @return
     */
    List<PersonInfo> personInfo(String peacId);

    /**
     * 打印指引单 根据体检编号查询体检信息
     * @param physicalExaminationId
     * @return
     * @throws Exception
     */
    List<Check> showListCheckLwr(String physicalExaminationId);

    /**
     * 根据体检编号查询信息 打印指引单
     * @return
     */
    PhysicalExamination selectPhysical(String  physicalExaminationId);
}
