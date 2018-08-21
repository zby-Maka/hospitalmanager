package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class PackageAndCheck {
    private Integer packageAndCheckId;
    private Integer packageId;
    private Integer checkId;

    public Integer getPackageAndCheckId() {
        return packageAndCheckId;
    }

    public void setPackageAndCheckId(Integer packageAndCheckId) {
        this.packageAndCheckId = packageAndCheckId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackageAndCheck that = (PackageAndCheck) o;
        return packageAndCheckId == that.packageAndCheckId &&
                Objects.equals(packageId, that.packageId) &&
                Objects.equals(checkId, that.checkId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(packageAndCheckId, packageId, checkId);
    }
}
