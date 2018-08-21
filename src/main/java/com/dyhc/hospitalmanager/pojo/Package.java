package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;


public class Package {
    private Integer packageId;
    private String packageName;
    private String scopeApplication;
    private String note;
    private Integer isEnable;

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getScopeApplication() {
        return scopeApplication;
    }

    public void setScopeApplication(String scopeApplication) {
        this.scopeApplication = scopeApplication;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

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
