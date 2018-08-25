package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.Check;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CheckService {

    /**
     * 查询所有的体检项
     * @return
     */
    List<Check> getAllCheckList();
}
