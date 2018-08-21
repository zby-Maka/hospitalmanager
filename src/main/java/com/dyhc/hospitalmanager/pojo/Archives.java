package com.dyhc.hospitalmanager.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Archives {
    private String archivesId;
    private Integer personId;
    private Timestamp archivesDate;

    @Basic
    @Column(name = "archives_id")
    public String getArchivesId() {
        return archivesId;
    }

    public void setArchivesId(String archivesId) {
        this.archivesId = archivesId;
    }

    @Basic
    @Column(name = "person_id")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "archives_ date")
    public Timestamp getArchivesDate() {
        return archivesDate;
    }

    public void setArchivesDate(Timestamp archivesDate) {
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
}
