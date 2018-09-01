package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.CommonResults;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonResultsService {

    /**
     * 添加常见结果信息
     * @param commonResults
     * @return
     */
    int addCommonResultsInfo(CommonResults commonResults);
    /**
     * 查询所有的常见结果
     */
    List<CommonResults> getCommResultslist(Integer checkId);
    /**
     * 修改常见结果信息
     * @param commonResults
     * @return
     */
    int updCommonResultsInfo(CommonResults commonResults);

    /**
     * 根据id查询常见结果(唯一)
     * @param commonResultsId
     * @return
     * @throws Exception
     */
    CommonResults getCommonResultsid(@Param("commonResultsId")Integer commonResultsId);
}
