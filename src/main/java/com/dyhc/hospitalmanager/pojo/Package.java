package com.dyhc.hospitalmanager.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Package {
    private int packageId;
    private String packageName;
    private String scopeApplication;
    private String note;
    private Integer isEnable;

    @Id
    @Column(name = "package_id")
    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    @Basic
    @Column(name = "package_name")
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Basic
    @Column(name = "scope_application")
    public String getScopeApplication() {
        return scopeApplication;
    }

    public void setScopeApplication(String scopeApplication) {
        this.scopeApplication = scopeApplication;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "is_enable")
    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return packageId == aPackage.packageId &&
                Objects.equals(packageName, aPackage.packageName) &&
                Objects.equals(scopeApplication, aPackage.scopeApplication) &&
                Objects.equals(note, aPackage.note) &&
                Objects.equals(isEnable, aPackage.isEnable);
    }

    @Override
    public int hashCode() {

        return Objects.hash(packageId, packageName, scopeApplication, note, isEnable);
    }
}
