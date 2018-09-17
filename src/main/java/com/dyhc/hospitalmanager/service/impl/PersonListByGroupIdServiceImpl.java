package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.PersonInfoMapper;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.service.PersonListByGroupIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 显示分组下边的人员信息
 */
@Service
public class PersonListByGroupIdServiceImpl implements PersonListByGroupIdService {
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Override
    public List<PersonInfo> getPersonInfoListByGroupId(Integer groupId) {
        List<PersonInfo> list = null;
        try {
            list = personInfoMapper.getPersonInfoListByGroupId(groupId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
