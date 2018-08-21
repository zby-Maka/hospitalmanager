package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.SectionTypeMapper;
import com.dyhc.hospitalmanager.service.SectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionTypeServiceImpl implements SectionTypeService {

    @Autowired
    private SectionTypeMapper sectionTypeMapper;
}
