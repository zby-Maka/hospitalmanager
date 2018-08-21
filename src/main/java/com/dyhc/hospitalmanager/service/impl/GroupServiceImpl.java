package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.GroupMapper;
import com.dyhc.hospitalmanager.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl  implements GroupService {

    @Autowired
    private GroupMapper groupMapper;
}
