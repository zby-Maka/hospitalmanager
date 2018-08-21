package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class PhysicalExaminationAndCombination {
    private Integer physicalExaminationAndCombinationId;
    private String physicalExaminationId;
    private Integer combinationId;
    private Integer physicalStatu;

    public Integer getPhysicalExaminationAndCombinationId() {
        return physicalExaminationAndCombinationId;
    }

    public void setPhysicalExaminationAndCombinationId(Integer physicalExaminationAndCombinationId) {
        this.physicalExaminationAndCombinationId = physicalExaminationAndCombinationId;
    }

    public String getPhysicalExaminationId() {
        return physicalExaminationId;
    }

    public void setPhysicalExaminationId(String physicalExaminationId) {
        this.physicalExaminationId = physicalExaminationId;
    }

    public Integer getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(Integer combinationId) {
        this.combinationId = combinationId;
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
        PhysicalExaminationAndCombination that = (PhysicalExaminationAndCombination) o;
        return physicalExaminationAndCombinationId == that.physicalExaminationAndCombinationId &&
                Objects.equals(physicalExaminationId, that.physicalExaminationId) &&
                Objects.equals(combinationId, that.combinationId) &&
                Objects.equals(physicalStatu, that.physicalStatu);
    }

    @Override
    public int hashCode() {

        return Objects.hash(physicalExaminationAndCombinationId, physicalExaminationId, combinationId, physicalStatu);
    }
}
