package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class MedicalEvents {
    private Integer medicalEventsId;
    private String eventsName;
    private String unit;
    private Double medicalResultData;
    private String medicalResult;
    private Integer checkResultId;

    public Integer getMedicalEventsId() {
        return medicalEventsId;
    }

    public void setMedicalEventsId(Integer medicalEventsId) {
        this.medicalEventsId = medicalEventsId;
    }

    public String getEventsName() {
        return eventsName;
    }

    public void setEventsName(String eventsName) {
        this.eventsName = eventsName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getMedicalResultData() {
        return medicalResultData;
    }

    public void setMedicalResultData(Double medicalResultData) {
        this.medicalResultData = medicalResultData;
    }

    public String getMedicalResult() {
        return medicalResult;
    }

    public void setMedicalResult(String medicalResult) {
        this.medicalResult = medicalResult;
    }

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
