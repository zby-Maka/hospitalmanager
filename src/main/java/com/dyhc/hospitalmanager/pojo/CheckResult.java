package com.dyhc.hospitalmanager.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class CheckResult {
    private int checkResultId;
    private String physicalExaminationId;
    private String checkId;
    private Integer roleInfoId;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDate;
    private Integer checkResultFinally;
    private String checkAdvice;
    private  CommonResults commonResults;
    private  MedicalEvents medicalEvents;

    public CommonResults getCommonResults() {
        return commonResults;
    }

    public void setCommonResults(CommonResults commonResults) {
        this.commonResults = commonResults;
    }

    public MedicalEvents getMedicalEvents() {
        return medicalEvents;
    }

    public void setMedicalEvents(MedicalEvents medicalEvents) {
        this.medicalEvents = medicalEvents;
    }

    public int getCheckResultId() {
        return checkResultId;
    }

    public void setCheckResultId(int checkResultId) {
        this.checkResultId = checkResultId;
    }

    public String getPhysicalExaminationId() {
        return physicalExaminationId;
    }

    public void setPhysicalExaminationId(String physicalExaminationId) {
        this.physicalExaminationId = physicalExaminationId;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public Integer getRoleInfoId() {
        return roleInfoId;
    }

    public void setRoleInfoId(Integer roleInfoId) {
        this.roleInfoId = roleInfoId;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Integer getCheckResultFinally() {
        return checkResultFinally;
    }

    public void setCheckResultFinally(Integer checkResultFinally) {
        this.checkResultFinally = checkResultFinally;
    }

    public String getCheckAdvice() {
        return checkAdvice;
    }

    public void setCheckAdvice(String checkAdvice) {
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
