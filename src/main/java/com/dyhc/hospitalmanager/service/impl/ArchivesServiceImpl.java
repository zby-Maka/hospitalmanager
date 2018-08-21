package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.ArchivesMapper;
import com.dyhc.hospitalmanager.service.ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchivesServiceImpl implements ArchivesService {

    @Autowired
    private ArchivesMapper archivesMapper;
}
