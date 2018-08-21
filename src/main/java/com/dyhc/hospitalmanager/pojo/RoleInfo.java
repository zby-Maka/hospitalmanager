package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class RoleInfo {
    private Integer roleInfoId;
    private String realName;
    private String userName;
    private String password;
    private Integer sectionId;
    private Integer roleTypeId;

    public Integer getRoleInfoId() {
        return roleInfoId;
    }

    public void setRoleInfoId(Integer roleInfoId) {
        this.roleInfoId = roleInfoId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getRoleTypeId() {
        return roleTypeId;
    }

    public void setRoleTypeId(Integer roleTypeId) {
        this.roleTypeId = roleTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleInfo roleInfo = (RoleInfo) o;
        return roleInfoId == roleInfo.roleInfoId &&
                Objects.equals(realName, roleInfo.realName) &&
                Objects.equals(userName, roleInfo.userName) &&
                Objects.equals(password, roleInfo.password) &&
                Objects.equals(sectionId, roleInfo.sectionId) &&
                Objects.equals(roleTypeId, roleInfo.roleTypeId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleInfoId, realName, userName, password, sectionId, roleTypeId);
    }
}
