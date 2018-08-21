package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class Section {
    private Integer sectionId;
    private String sectionName;
    private Integer sectionTypeId;
    private Integer sectionStatus;
    private String remark;

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
