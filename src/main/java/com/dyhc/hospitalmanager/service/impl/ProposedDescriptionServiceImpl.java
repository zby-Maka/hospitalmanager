package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.ProposedDescriptionMapper;
import com.dyhc.hospitalmanager.service.ProposedDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposedDescriptionServiceImpl implements ProposedDescriptionService {

    @Autowired
    private ProposedDescriptionMapper proposedDescriptionMapper;
}
