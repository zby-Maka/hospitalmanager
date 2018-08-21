package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class PhysicalExaminationAndPackage {
    private Integer physicalExaminationAndPackageId;
    private String physicalExaminationId;
    private Integer packageId;
    private Integer physicalStatu;

    public Integer getPhysicalExaminationAndPackageId() {
        return physicalExaminationAndPackageId;
    }

    public void setPhysicalExaminationAndPackageId(Integer physicalExaminationAndPackageId) {
        this.physicalExaminationAndPackageId = physicalExaminationAndPackageId;
    }

    public String getPhysicalExaminationId() {
        return physicalExaminationId;
    }

    public void setPhysicalExaminationId(String physicalExaminationId) {
        this.physicalExaminationId = physicalExaminationId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

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
