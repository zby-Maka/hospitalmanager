package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class CombinationAndCheck {
    private Integer combinationAndMedicalId;
    private Integer combinationId;
    private Integer checkId;

    public Integer getCombinationAndMedicalId() {
        return combinationAndMedicalId;
    }

    public void setCombinationAndMedicalId(Integer combinationAndMedicalId) {
        this.combinationAndMedicalId = combinationAndMedicalId;
    }

    public Integer getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(Integer combinationId) {
        this.combinationId = combinationId;
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
        CombinationAndCheck that = (CombinationAndCheck) o;
        return combinationAndMedicalId == that.combinationAndMedicalId &&
                Objects.equals(combinationId, that.combinationId) &&
                Objects.equals(checkId, that.checkId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(combinationAndMedicalId, combinationId, checkId);
    }
}
