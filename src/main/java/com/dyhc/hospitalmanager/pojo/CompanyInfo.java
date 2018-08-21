package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "company_info", schema = "health_examination_system", catalog = "")
public class CompanyInfo {
    private int companyId;
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

    @Id
    @Column(name = "company_id")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "spell_code")
    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }

    @Basic
    @Column(name = "company_principal")
    public String getCompanyPrincipal() {
        return companyPrincipal;
    }

    public void setCompanyPrincipal(String companyPrincipal) {
        this.companyPrincipal = companyPrincipal;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "bank_number")
    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    @Basic
    @Column(name = "company_nature")
    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    @Basic
    @Column(name = "authorized_strength")
    public Integer getAuthorizedStrength() {
        return authorizedStrength;
    }

    public void setAuthorizedStrength(Integer authorizedStrength) {
        this.authorizedStrength = authorizedStrength;
    }

    @Basic
    @Column(name = "is_delete")
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Basic
    @Column(name = "remark")
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
