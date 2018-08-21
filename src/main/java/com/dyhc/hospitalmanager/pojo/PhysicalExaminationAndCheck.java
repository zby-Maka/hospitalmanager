package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "physical_examination_and_ check", schema = "health_examination_system", catalog = "")
public class PhysicalExaminationAndCheck {
    private int physicalExaminationAndCheckId;
    private String physicalExaminationId;
    private Integer checkId;
    private Integer physicalStatu;

    @Id
    @Column(name = "physical_examination_and_ check_id")
    public int getPhysicalExaminationAndCheckId() {
        return physicalExaminationAndCheckId;
    }

    public void setPhysicalExaminationAndCheckId(int physicalExaminationAndCheckId) {
        this.physicalExaminationAndCheckId = physicalExaminationAndCheckId;
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
    @Column(name = "check_id")
    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
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
