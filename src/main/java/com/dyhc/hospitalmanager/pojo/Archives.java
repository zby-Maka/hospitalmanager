package com.dyhc.hospitalmanager.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class Archives {
    private String archivesId;
    private Integer personId;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date archivesDate;

    public String getArchivesId() {
        return archivesId;
    }

    public void setArchivesId(String archivesId) {
        this.archivesId = archivesId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Date getArchivesDate() {
        return archivesDate;
    }

    public void setArchivesDate(Date archivesDate) {
        this.archivesDate = archivesDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Archives archives = (Archives) o;
        return Objects.equals(archivesId, archives.archivesId) &&
                Objects.equals(personId, archives.personId) &&
                Objects.equals(archivesDate, archives.archivesDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(archivesId, personId, archivesDate);
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
