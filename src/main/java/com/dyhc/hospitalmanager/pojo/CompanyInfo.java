package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class CompanyInfo {
    private Integer companyId;
    private String companyName;
    private String spellCode;
    private String companyPrincipal;
    private String telephone;
    private String postalCode;
    private String address;
    private String bankName;
    private String bankNumber;
    private String companyNature;
    private Integer authorizedStrength;
    private Integer isDelete;
    private String remark;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }

    public String getCompanyPrincipal() {
        return companyPrincipal;
    }

    public void setCompanyPrincipal(String companyPrincipal) {
        this.companyPrincipal = companyPrincipal;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    public Integer getAuthorizedStrength() {
        return authorizedStrength;
    }

    public void setAuthorizedStrength(Integer authorizedStrength) {
        this.authorizedStrength = authorizedStrength;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyInfo that = (CompanyInfo) o;
        return companyId == that.companyId &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(spellCode, that.spellCode) &&
                Objects.equals(companyPrincipal, that.companyPrincipal) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(address, that.address) &&
                Objects.equals(bankName, that.bankName) &&
                Objects.equals(bankNumber, that.bankNumber) &&
                Objects.equals(companyNature, that.companyNature) &&
                Objects.equals(authorizedStrength, that.authorizedStrength) &&
                Objects.equals(isDelete, that.isDelete) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(companyId, companyName, spellCode, companyPrincipal, telephone, postalCode, address, bankName, bankNumber, companyNature, authorizedStrength, isDelete, remark);
    }
}
