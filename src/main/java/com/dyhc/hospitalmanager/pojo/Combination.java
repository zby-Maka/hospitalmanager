package com.dyhc.hospitalmanager.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Combination {
    private int combinationId;
    private Integer sectionId;
    private String combinationName;
    private String pinyinCode;
    private String promptInformation;
    private String resultToWay;
    private Integer isSpecimen;
    private String specimenType;
    private Integer isEnable;

    @Id
    @Column(name = "combination_id")
    public int getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(int combinationId) {
        this.combinationId = combinationId;
    }

    @Basic
    @Column(name = "section_id")
    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    @Basic
    @Column(name = "combination_name")
    public String getCombinationName() {
        return combinationName;
    }

    public void setCombinationName(String combinationName) {
        this.combinationName = combinationName;
    }

    @Basic
    @Column(name = "pinyin_code")
    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode;
    }

    @Basic
    @Column(name = "prompt_information")
    public String getPromptInformation() {
        return promptInformation;
    }

    public void setPromptInformation(String promptInformation) {
        this.promptInformation = promptInformation;
    }

    @Basic
    @Column(name = "result_to_way")
    public String getResultToWay() {
        return resultToWay;
    }

    public void setResultToWay(String resultToWay) {
        this.resultToWay = resultToWay;
    }

    @Basic
    @Column(name = "is_specimen")
    public Integer getIsSpecimen() {
        return isSpecimen;
    }

    public void setIsSpecimen(Integer isSpecimen) {
        this.isSpecimen = isSpecimen;
    }

    @Basic
    @Column(name = "specimen_type")
    public String getSpecimenType() {
        return specimenType;
    }

    public void setSpecimenType(String specimenType) {
        this.specimenType = specimenType;
    }

    @Basic
    @Column(name = "is_enable")
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
