package com.dyhc.hospitalmanager.pojo;

import java.util.ArrayList;
import java.util.List;

public class AllMedical {
    private Integer id;
    private String title;
    private List<Check> allCheck=new ArrayList<Check>();
    private List<Combination> allCombination=new ArrayList<Combination>();
    private List<Package> allPackage=new ArrayList<Package>();

//    private List<Object> list=new ArrayList<Object>();
//    public List<Object> getList() {
//        return list;
//    }
//
//    public void setList(List<Object> list) {
//        this.list = list;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Check> getAllCheck() {
        return allCheck;
    }

    public void setAllCheck(List<Check> allCheck) {
        this.allCheck = allCheck;
    }

    public List<Combination> getAllCombination() {
        return allCombination;
    }

    public void setAllCombination(List<Combination> allCombination) {
        this.allCombination = allCombination;
    }

    public List<Package> getAllPackage() {
        return allPackage;
    }

    public void setAllPackage(List<Package> allPackage) {
        this.allPackage = allPackage;
    }


}
