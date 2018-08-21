package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class PackageAndCombination {
    private Integer packageAndCombinationId;
    private Integer packageId;
    private Integer combinationId;

    public Integer getPackageAndCombinationId() {
        return packageAndCombinationId;
    }

    public void setPackageAndCombinationId(Integer packageAndCombinationId) {
        this.packageAndCombinationId = packageAndCombinationId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(Integer combinationId) {
        this.combinationId = combinationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackageAndCombination that = (PackageAndCombination) o;
        return packageAndCombinationId == that.packageAndCombinationId &&
                Objects.equals(packageId, that.packageId) &&
                Objects.equals(combinationId, that.combinationId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(packageAndCombinationId, packageId, combinationId);
    }
}
