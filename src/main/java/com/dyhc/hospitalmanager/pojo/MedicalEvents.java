package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "medical_events", schema = "health_examination_system", catalog = "")
public class MedicalEvents {
    private int medicalEventsId;
    private String eventsName;
    private String unit;
    private Double medicalResultData;
    private String medicalResult;
    private Integer checkResultId;

    @Id
    @Column(name = "medical_events_id")
    public int getMedicalEventsId() {
        return medicalEventsId;
    }

    public void setMedicalEventsId(int medicalEventsId) {
        this.medicalEventsId = medicalEventsId;
    }

    @Basic
    @Column(name = "events_name")
    public String getEventsName() {
        return eventsName;
    }

    public void setEventsName(String eventsName) {
        this.eventsName = eventsName;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "medical_result_data")
    public Double getMedicalResultData() {
        return medicalResultData;
    }

    public void setMedicalResultData(Double medicalResultData) {
        this.medicalResultData = medicalResultData;
    }

    @Basic
    @Column(name = "medical_result")
    public String getMedicalResult() {
        return medicalResult;
    }

    public void setMedicalResult(String medicalResult) {
        this.medicalResult = medicalResult;
    }

    @Basic
    @Column(name = "check_result _id")
    public Integer getCheckResultId() {
        return checkResultId;
    }

    public void setCheckResultId(Integer checkResultId) {
        this.checkResultId = checkResultId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalEvents that = (MedicalEvents) o;
        return medicalEventsId == that.medicalEventsId &&
                Objects.equals(eventsName, that.eventsName) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(medicalResultData, that.medicalResultData) &&
                Objects.equals(medicalResult, that.medicalResult) &&
                Objects.equals(checkResultId, that.checkResultId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(medicalEventsId, eventsName, unit, medicalResultData, medicalResult, checkResultId);
    }
}
