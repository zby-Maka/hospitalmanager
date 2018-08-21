package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "person_info", schema = "health_examination_system", catalog = "")
public class PersonInfo {
    private int personId;
    private String personName;
    private Integer personAge;
    private Date personBirthday;
    private String personSex;
    private String personIdCard;
    private String isMarry;
    private String personTelephone;
    private String personAddress;
    private String personNameSpellCode;
    private String personType;
    private Integer groupId;
    private Timestamp createDate;

    @Id
    @Column(name = "person_id")
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "person_name")
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Basic
    @Column(name = "person_age")
    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }

    @Basic
    @Column(name = "person_birthday")
    public Date getPersonBirthday() {
        return personBirthday;
    }

    public void setPersonBirthday(Date personBirthday) {
        this.personBirthday = personBirthday;
    }

    @Basic
    @Column(name = "person_sex")
    public String getPersonSex() {
        return personSex;
    }

    public void setPersonSex(String personSex) {
        this.personSex = personSex;
    }

    @Basic
    @Column(name = "person_id_card")
    public String getPersonIdCard() {
        return personIdCard;
    }

    public void setPersonIdCard(String personIdCard) {
        this.personIdCard = personIdCard;
    }

    @Basic
    @Column(name = "is_marry")
    public String getIsMarry() {
        return isMarry;
    }

    public void setIsMarry(String isMarry) {
        this.isMarry = isMarry;
    }

    @Basic
    @Column(name = "person_telephone")
    public String getPersonTelephone() {
        return personTelephone;
    }

    public void setPersonTelephone(String personTelephone) {
        this.personTelephone = personTelephone;
    }

    @Basic
    @Column(name = "person_address")
    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    @Basic
    @Column(name = "person_name_spell_code")
    public String getPersonNameSpellCode() {
        return personNameSpellCode;
    }

    public void setPersonNameSpellCode(String personNameSpellCode) {
        this.personNameSpellCode = personNameSpellCode;
    }

    @Basic
    @Column(name = "person_type")
    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    @Basic
    @Column(name = "group_id")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
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
