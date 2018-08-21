package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class PhysicalExaminationAndCheck {
    private Integer physicalExaminationAndCheckId;
    private String physicalExaminationId;
    private Integer checkId;
    private Integer physicalStatu;

    public Integer getPhysicalExaminationAndCheckId() {
        return physicalExaminationAndCheckId;
    }

    public void setPhysicalExaminationAndCheckId(Integer physicalExaminationAndCheckId) {
        this.physicalExaminationAndCheckId = physicalExaminationAndCheckId;
    }

    public String getPhysicalExaminationId() {
        return physicalExaminationId;
    }

    public void setPhysicalExaminationId(String physicalExaminationId) {
        this.physicalExaminationId = physicalExaminationId;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
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
        PhysicalExaminationAndCheck that = (PhysicalExaminationAndCheck) o;
        return physicalExaminationAndCheckId == that.physicalExaminationAndCheckId &&
                Objects.equals(physicalExaminationId, that.physicalExaminationId) &&
                Objects.equals(checkId, that.checkId) &&
                Objects.equals(physicalStatu, that.physicalStatu);
    }

    @Override
    public int hashCode() {

        return Objects.hash(physicalExaminationAndCheckId, physicalExaminationId, checkId, physicalStatu);
    }
}
