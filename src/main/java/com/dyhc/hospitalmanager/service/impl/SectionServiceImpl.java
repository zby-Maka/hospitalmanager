package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.SectionMapper;
import com.dyhc.hospitalmanager.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionMapper sectionMapper;
}
