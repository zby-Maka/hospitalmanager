package com.dyhc.hospitalmanager.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class PhysicalExamination {
    private String physicalExaminationId;
    private Integer personId;
    private String archivesId;
    private Integer medicalResultsId;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date medicalTime;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Integer status;
    public String getPhysicalExaminationId() {
        return physicalExaminationId;
    }

    public void setPhysicalExaminationId(String physicalExaminationId) {
        this.physicalExaminationId = physicalExaminationId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getArchivesId() {
        return archivesId;
    }

    public void setArchivesId(String archivesId) {
        this.archivesId = archivesId;
    }

    public Integer getMedicalResultsId() {
        return medicalResultsId;
    }

    public void setMedicalResultsId(Integer medicalResultsId) {
        this.medicalResultsId = medicalResultsId;
    }

    public Date getMedicalTime() {
        return medicalTime;
    }

    public void setMedicalTime(Date medicalTime) {
        this.medicalTime = medicalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalExamination that = (PhysicalExamination) o;
        return Objects.equals(physicalExaminationId, that.physicalExaminationId) &&
                Objects.equals(personId, that.personId) &&
                Objects.equals(archivesId, that.archivesId) &&
                Objects.equals(medicalResultsId, that.medicalResultsId) &&
                Objects.equals(medicalTime, that.medicalTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(physicalExaminationId, personId, archivesId, medicalResultsId, medicalTime);
    }
}
