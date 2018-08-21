package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "physical_examination_and_ combination", schema = "health_examination_system", catalog = "")
public class PhysicalExaminationAndCombination {
    private int physicalExaminationAndCombinationId;
    private String physicalExaminationId;
    private Integer combinationId;
    private Integer physicalStatu;

    @Id
    @Column(name = "physical_examination_and_ combination_id")
    public int getPhysicalExaminationAndCombinationId() {
        return physicalExaminationAndCombinationId;
    }

    public void setPhysicalExaminationAndCombinationId(int physicalExaminationAndCombinationId) {
        this.physicalExaminationAndCombinationId = physicalExaminationAndCombinationId;
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
    @Column(name = "combination_id")
    public Integer getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(Integer combinationId) {
        this.combinationId = combinationId;
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
