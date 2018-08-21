package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "physical_examination_and_package", schema = "health_examination_system", catalog = "")
public class PhysicalExaminationAndPackage {
    private int physicalExaminationAndPackageId;
    private String physicalExaminationId;
    private Integer packageId;
    private Integer physicalStatu;

    @Id
    @Column(name = "physical_examination_and_package_id")
    public int getPhysicalExaminationAndPackageId() {
        return physicalExaminationAndPackageId;
    }

    public void setPhysicalExaminationAndPackageId(int physicalExaminationAndPackageId) {
        this.physicalExaminationAndPackageId = physicalExaminationAndPackageId;
    }

    @Basic
    @Column(name = "physical_examination_id")
    public String getPhysicalExaminationId() {
        return physicalExaminationId;
    }

    public void setPhysicalExaminationId(String physicalExaminationId) {
        this.physicalExaminationId = physicalExaminationId;
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
    @Column(name = "physical_statu")
    public Integer getPhysicalStatu() {
        return physicalStatu;
    }

    public void setPhysicalStatu(Integer physicalStatu) {
        this.physicalStatu = physicalStatu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalExaminationAndPackage that = (PhysicalExaminationAndPackage) o;
        return physicalExaminationAndPackageId == that.physicalExaminationAndPackageId &&
                Objects.equals(physicalExaminationId, that.physicalExaminationId) &&
                Objects.equals(packageId, that.packageId) &&
                Objects.equals(physicalStatu, that.physicalStatu);
    }

    @Override
    public int hashCode() {

        return Objects.hash(physicalExaminationAndPackageId, physicalExaminationId, packageId, physicalStatu);
    }
}
