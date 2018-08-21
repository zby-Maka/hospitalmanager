package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.PackageMapper;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageMapper packageMapper;

    @Override
    public List<Package> getPackage() {
        List<Package> packageList = new ArrayList<Package>();
        Package packageCombination=null;
        Package packageCheck=null;
        try {
            List<Integer> packageIdList = packageIdList = packageMapper.getAllPackageId();
            for (Integer packageId:packageIdList) {
                packageCombination =  packageMapper.getPackageCombination(packageId);
                packageCheck =  packageMapper.getPackageCheck(packageId);
                if(packageCombination!=null)
                    packageCombination.setPackageCheckList(packageCheck.getPackageCheckList());

                packageList.add(packageCombination);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packageList;
    }
}
