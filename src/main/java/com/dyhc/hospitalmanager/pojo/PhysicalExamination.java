package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "physical_examination", schema = "health_examination_system", catalog = "")
public class PhysicalExamination {
    private String physicalExaminationId;
    private Integer personId;
    private String archivesId;
    private Integer medicalResultsId;
    private Timestamp medicalTime;

    @Id
    @Column(name = "physical_examination_id")
    public String getPhysicalExaminationId() {
        return physicalExaminationId;
    }

    public void setPhysicalExaminationId(String physicalExaminationId) {
        this.physicalExaminationId = physicalExaminationId;
    }

    @Basic
    @Column(name = "person_id")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "archives_id")
    public String getArchivesId() {
        return archivesId;
    }

    public void setArchivesId(String archivesId) {
        this.archivesId = archivesId;
    }

    @Basic
    @Column(name = "medical_results_id")
    public Integer getMedicalResultsId() {
        return medicalResultsId;
    }

    public void setMedicalResultsId(Integer medicalResultsId) {
        this.medicalResultsId = medicalResultsId;
    }

    @Basic
    @Column(name = "medical_time")
    public Timestamp getMedicalTime() {
        return medicalTime;
    }

    public void setMedicalTime(Timestamp medicalTime) {
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
