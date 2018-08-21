package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "section_type", schema = "health_examination_system", catalog = "")
public class SectionType {
    private int sectionTypeId;
    private String sectionTypeName;

    @Id
    @Column(name = "section_type_id")
    public int getSectionTypeId() {
        return sectionTypeId;
    }

    public void setSectionTypeId(int sectionTypeId) {
        this.sectionTypeId = sectionTypeId;
    }

    @Basic
    @Column(name = "section _type_name")
    public String getSectionTypeName() {
        return sectionTypeName;
    }

    public void setSectionTypeName(String sectionTypeName) {
        this.sectionTypeName = sectionTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionType that = (SectionType) o;
        return sectionTypeId == that.sectionTypeId &&
                Objects.equals(sectionTypeName, that.sectionTypeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sectionTypeId, sectionTypeName);
    }
}
