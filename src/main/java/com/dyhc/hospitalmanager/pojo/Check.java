package com.dyhc.hospitalmanager.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Check {

    private Integer checkId;
    private Integer sectionId;
    private String checkName;
    private String termSex;
    private String checkSpellCode;
    private BigDecimal checkPrice;
    private String checkAddress;
    private String unit;
    private Double referenceFloor;
    private Double referenceCeil;
    private String promptFlat;
    private String promptHigh;
    private Double minValue;
    private Double maxValue;
    private String remark;
    private Integer isEnable;
    private List<MedicalEvents> medicalEventsList=new ArrayList<MedicalEvents>();
    private  CommonResults commonResults;
    private ProposedDescription proposedDescription;

    public CommonResults getCommonResults() {
        return commonResults;
    }

    public void setCommonResults(CommonResults commonResults) {
        this.commonResults = commonResults;
    }

    public ProposedDescription getProposedDescription() {
        return proposedDescription;
    }

    public void setProposedDescription(ProposedDescription proposedDescription) {
        this.proposedDescription = proposedDescription;
    }

    public List<MedicalEvents> getMedicalEventsList() {
        return medicalEventsList;
    }

    public void setMedicalEventsList(List<MedicalEvents> medicalEventsList) {
        this.medicalEventsList = medicalEventsList;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getTermSex() {
        return termSex;
    }

    public void setTermSex(String termSex) {
        this.termSex = termSex;
    }

    public String getCheckSpellCode() {
        return checkSpellCode;
    }

    public void setCheckSpellCode(String checkSpellCode) {
        this.checkSpellCode = checkSpellCode;
    }

    public BigDecimal getCheckPrice() {
        return checkPrice;
    }

    public void setCheckPrice(BigDecimal checkPrice) {
        this.checkPrice = checkPrice;
    }

    public String getCheckAddress() {
        return checkAddress;
    }

    public void setCheckAddress(String checkAddress) {
        this.checkAddress = checkAddress;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getReferenceFloor() {
        return referenceFloor;
    }

    public void setReferenceFloor(Double referenceFloor) {
        this.referenceFloor = referenceFloor;
    }

    public Double getReferenceCeil() {
        return referenceCeil;
    }

    public void setReferenceCeil(Double referenceCeil) {
        this.referenceCeil = referenceCeil;
    }

    public String getPromptFlat() {
        return promptFlat;
    }

    public void setPromptFlat(String promptFlat) {
        this.promptFlat = promptFlat;
    }

    public String getPromptHigh() {
        return promptHigh;
    }

    public void setPromptHigh(String promptHigh) {
        this.promptHigh = promptHigh;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        Check check = (Check) o;
        return checkId == check.checkId &&
                Objects.equals(sectionId, check.sectionId) &&
                Objects.equals(checkName, check.checkName) &&
                Objects.equals(termSex, check.termSex) &&
                Objects.equals(checkSpellCode, check.checkSpellCode) &&
                Objects.equals(checkPrice, check.checkPrice) &&
                Objects.equals(checkAddress, check.checkAddress) &&
                Objects.equals(unit, check.unit) &&
                Objects.equals(referenceFloor, check.referenceFloor) &&
                Objects.equals(referenceCeil, check.referenceCeil) &&
                Objects.equals(promptFlat, check.promptFlat) &&
                Objects.equals(promptHigh, check.promptHigh) &&
                Objects.equals(minValue, check.minValue) &&
                Objects.equals(maxValue, check.maxValue) &&
                Objects.equals(remark, check.remark) &&
                Objects.equals(isEnable, check.isEnable);
    }

    @Override
    public int hashCode() {

        return Objects.hash(checkId, sectionId, checkName, termSex, checkSpellCode, checkPrice, checkAddress, unit, referenceFloor, referenceCeil, promptFlat, promptHigh, minValue, maxValue, remark, isEnable);
    }
}
