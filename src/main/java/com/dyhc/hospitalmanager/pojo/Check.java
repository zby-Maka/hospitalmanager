package com.dyhc.hospitalmanager.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Check {
    private int checkId;
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

    @Id
    @Column(name = "check_id")
    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
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
    @Column(name = "check_name")
    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    @Basic
    @Column(name = "term_sex")
    public String getTermSex() {
        return termSex;
    }

    public void setTermSex(String termSex) {
        this.termSex = termSex;
    }

    @Basic
    @Column(name = "check_spell_code")
    public String getCheckSpellCode() {
        return checkSpellCode;
    }

    public void setCheckSpellCode(String checkSpellCode) {
        this.checkSpellCode = checkSpellCode;
    }

    @Basic
    @Column(name = "check_price")
    public BigDecimal getCheckPrice() {
        return checkPrice;
    }

    public void setCheckPrice(BigDecimal checkPrice) {
        this.checkPrice = checkPrice;
    }

    @Basic
    @Column(name = "check_address")
    public String getCheckAddress() {
        return checkAddress;
    }

    public void setCheckAddress(String checkAddress) {
        this.checkAddress = checkAddress;
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
    @Column(name = "reference_floor")
    public Double getReferenceFloor() {
        return referenceFloor;
    }

    public void setReferenceFloor(Double referenceFloor) {
        this.referenceFloor = referenceFloor;
    }

    @Basic
    @Column(name = "reference_ceil")
    public Double getReferenceCeil() {
        return referenceCeil;
    }

    public void setReferenceCeil(Double referenceCeil) {
        this.referenceCeil = referenceCeil;
    }

    @Basic
    @Column(name = "prompt_flat")
    public String getPromptFlat() {
        return promptFlat;
    }

    public void setPromptFlat(String promptFlat) {
        this.promptFlat = promptFlat;
    }

    @Basic
    @Column(name = "prompt_high")
    public String getPromptHigh() {
        return promptHigh;
    }

    public void setPromptHigh(String promptHigh) {
        this.promptHigh = promptHigh;
    }

    @Basic
    @Column(name = "min_value")
    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    @Basic
    @Column(name = "max_value")
    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
