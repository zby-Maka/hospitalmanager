package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "package_and_ combination", schema = "health_examination_system", catalog = "")
public class PackageAndCombination {
    private int packageAndCombinationId;
    private Integer packageId;
    private Integer combinationId;

    @Id
    @Column(name = "package_and_ combination_id")
    public int getPackageAndCombinationId() {
        return packageAndCombinationId;
    }

    public void setPackageAndCombinationId(int packageAndCombinationId) {
        this.packageAndCombinationId = packageAndCombinationId;
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
    @Column(name = "combination_id")
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
