package com.dyhc.hospitalmanager.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Section {
    private int sectionId;
    private String sectionName;
    private Integer sectionTypeId;
    private Integer sectionStatus;
    private String remark;

    @Id
    @Column(name = "section_id")
    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    @Basic
    @Column(name = "section _name")
    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Basic
    @Column(name = "section _type_id")
    public Integer getSectionTypeId() {
        return sectionTypeId;
    }

    public void setSectionTypeId(Integer sectionTypeId) {
        this.sectionTypeId = sectionTypeId;
    }

    @Basic
    @Column(name = "section _status")
    public Integer getSectionStatus() {
        return sectionStatus;
    }

    public void setSectionStatus(Integer sectionStatus) {
        this.sectionStatus = sectionStatus;
    }

    @Basic
    @Column(name = "remark")
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
