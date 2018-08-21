package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "package_and_ check", schema = "health_examination_system", catalog = "")
public class PackageAndCheck {
    private int packageAndCheckId;
    private Integer packageId;
    private Integer checkId;

    @Id
    @Column(name = "package_and_ check_id")
    public int getPackageAndCheckId() {
        return packageAndCheckId;
    }

    public void setPackageAndCheckId(int packageAndCheckId) {
        this.packageAndCheckId = packageAndCheckId;
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
    @Column(name = "check_id")
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
