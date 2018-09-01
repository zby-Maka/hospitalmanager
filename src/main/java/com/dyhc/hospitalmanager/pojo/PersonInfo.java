package com.dyhc.hospitalmanager.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PersonInfo {
    private Integer personId;
    private String personName;
    private Integer personAge;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date personBirthday;
    private String personSex;
    private String personIdCard;
    private String isMarry;
    private String personTelephone;
    private String personAddress;
    private String personNameSpellCode;
    private String personType;
    private Integer groupId;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private List<Check> checkList;
    private String dateTsmes;

    public String getDateTsmes() {
        return dateTsmes;
    }

    public void setDateTsmes(String dateTsmes) {
        this.dateTsmes = dateTsmes;
    }

    private String yuDate;

    public String getYuDate() {
        return yuDate;
    }

    public void setYuDate(String yuDate) {
        this.yuDate = yuDate;
    }

    public List<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Check> checkList) {
        this.checkList = checkList;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }

    public Date getPersonBirthday() {
        return personBirthday;
    }

    public void setPersonBirthday(Date personBirthday) {
        this.personBirthday = personBirthday;
    }

    public String getPersonSex() {
        return personSex;
    }

    public void setPersonSex(String personSex) {
        this.personSex = personSex;
    }

    public String getPersonIdCard() {
        return personIdCard;
    }

    public void setPersonIdCard(String personIdCard) {
        this.personIdCard = personIdCard;
    }

    public String getIsMarry() {
        return isMarry;
    }

    public void setIsMarry(String isMarry) {
        this.isMarry = isMarry;
    }

    public String getPersonTelephone() {
        return personTelephone;
    }

    public void setPersonTelephone(String personTelephone) {
        this.personTelephone = personTelephone;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getPersonNameSpellCode() {
        return personNameSpellCode;
    }

    public void setPersonNameSpellCode(String personNameSpellCode) {
        this.personNameSpellCode = personNameSpellCode;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public Integer getGroup1Id() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonInfo that = (PersonInfo) o;
        return personId == that.personId &&
                Objects.equals(personName, that.personName) &&
                Objects.equals(personAge, that.personAge) &&
                Objects.equals(personBirthday, that.personBirthday) &&
                Objects.equals(personSex, that.personSex) &&
                Objects.equals(personIdCard, that.personIdCard) &&
                Objects.equals(isMarry, that.isMarry) &&
                Objects.equals(personTelephone, that.personTelephone) &&
                Objects.equals(personAddress, that.personAddress) &&
                Objects.equals(personNameSpellCode, that.personNameSpellCode) &&
                Objects.equals(personType, that.personType) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(personId, personName, personAge, personBirthday, personSex, personIdCard, isMarry, personTelephone, personAddress, personNameSpellCode, personType, groupId, createDate);
    }
}
