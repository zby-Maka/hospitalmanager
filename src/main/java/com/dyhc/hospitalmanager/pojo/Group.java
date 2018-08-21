package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;


public class Group {
    private Integer groupId;
    private String groupName;
    private Integer companyId;
    private String termSex;
    private String termIsMarry;
    private Integer termAgeFloor;
    private Integer termAgeCeil;
    private Integer packageId;
    private Integer isDelete;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getTermSex() {
        return termSex;
    }

    public void setTermSex(String termSex) {
        this.termSex = termSex;
    }

    public String getTermIsMarry() {
        return termIsMarry;
    }

    public void setTermIsMarry(String termIsMarry) {
        this.termIsMarry = termIsMarry;
    }

    public Integer getTermAgeFloor() {
        return termAgeFloor;
    }

    public void setTermAgeFloor(Integer termAgeFloor) {
        this.termAgeFloor = termAgeFloor;
    }

    public Integer getTermAgeCeil() {
        return termAgeCeil;
    }

    public void setTermAgeCeil(Integer termAgeCeil) {
        this.termAgeCeil = termAgeCeil;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

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
