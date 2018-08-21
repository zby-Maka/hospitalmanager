package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class Combination {
    private Integer combinationId;
    private Integer sectionId;
    private String combinationName;
    private String pinyinCode;
    private String promptInformation;
    private String resultToWay;
    private Integer isSpecimen;
    private String specimenType;
    private Integer isEnable;

    public Integer getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(Integer combinationId) {
        this.combinationId = combinationId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getCombinationName() {
        return combinationName;
    }

    public void setCombinationName(String combinationName) {
        this.combinationName = combinationName;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode;
    }

    public String getPromptInformation() {
        return promptInformation;
    }

    public void setPromptInformation(String promptInformation) {
        this.promptInformation = promptInformation;
    }

    public String getResultToWay() {
        return resultToWay;
    }

    public void setResultToWay(String resultToWay) {
        this.resultToWay = resultToWay;
    }

    public Integer getIsSpecimen() {
        return isSpecimen;
    }

    public void setIsSpecimen(Integer isSpecimen) {
        this.isSpecimen = isSpecimen;
    }

    public String getSpecimenType() {
        return specimenType;
    }

    public void setSpecimenType(String specimenType) {
        this.specimenType = specimenType;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combination that = (Combination) o;
        return combinationId == that.combinationId &&
                Objects.equals(sectionId, that.sectionId) &&
                Objects.equals(combinationName, that.combinationName) &&
                Objects.equals(pinyinCode, that.pinyinCode) &&
                Objects.equals(promptInformation, that.promptInformation) &&
                Objects.equals(resultToWay, that.resultToWay) &&
                Objects.equals(isSpecimen, that.isSpecimen) &&
                Objects.equals(specimenType, that.specimenType) &&
                Objects.equals(isEnable, that.isEnable);
    }

    @Override
    public int hashCode() {

        return Objects.hash(combinationId, sectionId, combinationName, pinyinCode, promptInformation, resultToWay, isSpecimen, specimenType, isEnable);
    }
}
