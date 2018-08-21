package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "combination_and_ check", schema = "health_examination_system", catalog = "")
public class CombinationAndCheck {
    private int combinationAndMedicalId;
    private Integer combinationId;
    private Integer checkId;

    @Id
    @Column(name = "combination_and_ medical_id")
    public int getCombinationAndMedicalId() {
        return combinationAndMedicalId;
    }

    public void setCombinationAndMedicalId(int combinationAndMedicalId) {
        this.combinationAndMedicalId = combinationAndMedicalId;
    }

    @Basic
    @Column(name = "combination_id")
    public Integer getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(Integer combinationId) {
        this.combinationId = combinationId;
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
