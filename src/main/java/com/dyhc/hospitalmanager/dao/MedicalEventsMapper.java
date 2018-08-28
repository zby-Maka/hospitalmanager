package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.MedicalEvents;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MedicalEventsMapper {

    /**
     * 科室是检验:将检验结果添加到检验明细表中
     * @param medicalEvents
     * @return
     */
    Integer addMedicalEvent(MedicalEvents medicalEvents)throws  Exception;
}
