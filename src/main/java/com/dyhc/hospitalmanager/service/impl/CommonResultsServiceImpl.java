package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.CommonResultsMapper;
import com.dyhc.hospitalmanager.pojo.CommonResults;
import com.dyhc.hospitalmanager.service.CommonResultsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommonResultsServiceImpl implements CommonResultsService {
    @Resource
    private CommonResultsMapper commonResultsMapper;
    @Override
    public int addCommonResultsInfo(CommonResults commonResults) {
        int result=0;
        try {
            result=commonResultsMapper.addCommonResultsInfo(commonResults);
        } catch (Exception e) {
            e.printStackTrace();
            result=0;
        }
        return result;
    }

    @Override
    public List<CommonResults> getCommResultslist(Integer checkId) {
        try {
            return commonResultsMapper.getCommResultslist(checkId);
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public int updCommonResultsInfo(CommonResults commonResults) {
        int result=0;
        try {
            result= commonResultsMapper.updCommonResultsInfo(commonResults);
        } catch (Exception e) {
            e.printStackTrace();
            result=0;
        }
        return  result;
    }

    @Override
    public CommonResults getCommonResultsid(Integer commonResultsId) {
        try {
            return commonResultsMapper.getCommonResultsid(commonResultsId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
