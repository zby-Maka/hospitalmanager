package com.dyhc.hospitalmanager.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 打印指引单
 */
@Mapper
@Repository
public interface GuideService {
    /**
     * 添加单位预约人员与检查项的关系
     * @return 体检编号
     */
    String addRelationPerson(Integer personId,Integer[] packId,Integer packageId);
}
