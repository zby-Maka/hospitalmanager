package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.PersonInfoMapper;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private PersonInfoMapper personInfoMapper;

    @Override
    public List<PersonInfo> getPersonBypeacId(String peacId) {
        try {
            return  personInfoMapper.getPersonBypeacId(peacId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public PersonInfo getPersonInfoByIdAndPhone(String physical_examination_id, String person_telphone) {
        try {
            return personInfoMapper.getPersonInfoByIdAndPhone(physical_examination_id,person_telphone);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
