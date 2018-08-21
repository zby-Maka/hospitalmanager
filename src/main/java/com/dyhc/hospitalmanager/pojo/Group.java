package com.dyhc.hospitalmanager.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Group {
    private int groupId;
    private String groupName;
    private Integer companyId;
    private String termSex;
    private String termIsMarry;
    private Integer termAgeFloor;
    private Integer termAgeCeil;
    private Integer packageId;
    private Integer isDelete;

    @Id
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "term_sex")
    public String getTermSex() {
        return termSex;
    }

    public void setTermSex(String termSex) {
        this.termSex = termSex;
    }

    @Basic
    @Column(name = "term_is_marry")
    public String getTermIsMarry() {
        return termIsMarry;
    }

    public void setTermIsMarry(String termIsMarry) {
        this.termIsMarry = termIsMarry;
    }

    @Basic
    @Column(name = "term_age_floor")
    public Integer getTermAgeFloor() {
        return termAgeFloor;
    }

    public void setTermAgeFloor(Integer termAgeFloor) {
        this.termAgeFloor = termAgeFloor;
    }

    @Basic
    @Column(name = "term_age_ceil")
    public Integer getTermAgeCeil() {
        return termAgeCeil;
    }

    public void setTermAgeCeil(Integer termAgeCeil) {
        this.termAgeCeil = termAgeCeil;
    }

    @Basic
    @Column(name = "package_id")
    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    @Basic
    @Column(name = "is_delete")
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupId == group.groupId &&
                Objects.equals(groupName, group.groupName) &&
                Objects.equals(companyId, group.companyId) &&
                Objects.equals(termSex, group.termSex) &&
                Objects.equals(termIsMarry, group.termIsMarry) &&
                Objects.equals(termAgeFloor, group.termAgeFloor) &&
                Objects.equals(termAgeCeil, group.termAgeCeil) &&
                Objects.equals(packageId, group.packageId) &&
                Objects.equals(isDelete, group.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(groupId, groupName, companyId, termSex, termIsMarry, termAgeFloor, termAgeCeil, packageId, isDelete);
    }
}
