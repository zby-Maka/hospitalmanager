package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role_info", schema = "health_examination_system", catalog = "")
public class RoleInfo {
    private int roleInfoId;
    private String realName;
    private String userName;
    private String password;
    private Integer sectionId;
    private Integer roleTypeId;

    @Id
    @Column(name = "role_info_id")
    public int getRoleInfoId() {
        return roleInfoId;
    }

    public void setRoleInfoId(int roleInfoId) {
        this.roleInfoId = roleInfoId;
    }

    @Basic
    @Column(name = "real_name")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "section_id")
    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    @Basic
    @Column(name = "role_type_id")
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
