package com.dyhc.hospitalmanager.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Section {
    private Integer sectionId;
    private String sectionName;
    private Integer sectionTypeId;
    private Integer sectionStatus;
    private String remark;


    //科室下的组合项目
    List<Combination>sectioandcombinationList=new ArrayList<Combination>();
    //科室下的单个体检项目
    List<Check>sectionandcheckList=new ArrayList<Check>();

    public List<Combination> getSectioandcombinationList() {
        return sectioandcombinationList;
    }

    public void setSectioandcombinationList(List<Combination> sectioandcombinationList) {
        this.sectioandcombinationList = sectioandcombinationList;
    }

    public List<Check> getSectionandcheckList() {
        return sectionandcheckList;
    }

    public void setSectionandcheckList(List<Check> sectionandcheckList) {
        this.sectionandcheckList = sectionandcheckList;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getSectionTypeId() {
        return sectionTypeId;
    }

    public void setSectionTypeId(Integer sectionTypeId) {
        this.sectionTypeId = sectionTypeId;
    }

    public Integer getSectionStatus() {
        return sectionStatus;
    }

    public void setSectionStatus(Integer sectionStatus) {
        this.sectionStatus = sectionStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return sectionId == section.sectionId &&
                Objects.equals(sectionName, section.sectionName) &&
                Objects.equals(sectionTypeId, section.sectionTypeId) &&
                Objects.equals(sectionStatus, section.sectionStatus) &&
                Objects.equals(remark, section.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sectionId, sectionName, sectionTypeId, sectionStatus, remark);
    }
}
