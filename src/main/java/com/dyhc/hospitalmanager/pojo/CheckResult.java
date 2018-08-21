package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "check_result", schema = "health_examination_system", catalog = "")
public class CheckResult {
    private int checkResultId;
    private String physicalExaminationId;
    private String checkId;
    private Integer roleInfoId;
    private Timestamp checkDate;
    private Integer checkResultFinally;
    private Integer checkAdvice;

    @Id
    @Column(name = "check_result _id")
    public int getCheckResultId() {
        return checkResultId;
    }

    public void setCheckResultId(int checkResultId) {
        this.checkResultId = checkResultId;
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
    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    @Basic
    @Column(name = "role_info_id")
    public Integer getRoleInfoId() {
        return roleInfoId;
    }

    public void setRoleInfoId(Integer roleInfoId) {
        this.roleInfoId = roleInfoId;
    }

    @Basic
    @Column(name = "check_date")
    public Timestamp getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Timestamp checkDate) {
        this.checkDate = checkDate;
    }

    @Basic
    @Column(name = "check_result_finally")
    public Integer getCheckResultFinally() {
        return checkResultFinally;
    }

    public void setCheckResultFinally(Integer checkResultFinally) {
        this.checkResultFinally = checkResultFinally;
    }

    @Basic
    @Column(name = "check_advice")
    public Integer getCheckAdvice() {
        return checkAdvice;
    }

    public void setCheckAdvice(Integer checkAdvice) {
        this.checkAdvice = checkAdvice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckResult that = (CheckResult) o;
        return checkResultId == that.checkResultId &&
                Objects.equals(physicalExaminationId, that.physicalExaminationId) &&
                Objects.equals(checkId, that.checkId) &&
                Objects.equals(roleInfoId, that.roleInfoId) &&
                Objects.equals(checkDate, that.checkDate) &&
                Objects.equals(checkResultFinally, that.checkResultFinally) &&
                Objects.equals(checkAdvice, that.checkAdvice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(checkResultId, physicalExaminationId, checkId, roleInfoId, checkDate, checkResultFinally, checkAdvice);
    }
}
