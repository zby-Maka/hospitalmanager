package com.dyhc.hospitalmanager.service;

import com.dyhc.hospitalmanager.pojo.Package;

import java.util.List;

public interface PackageService {

    /**
     * 查询所有套餐其下面的所有体检项及组合项
     * @param
     * @return
     */
    List<Package> getPackage()throws  Exception;
}
