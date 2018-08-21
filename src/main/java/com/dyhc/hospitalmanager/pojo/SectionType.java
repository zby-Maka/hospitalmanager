package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class SectionType {
    private Integer sectionTypeId;
    private String sectionTypeName;

    public Integer getSectionTypeId() {
        return sectionTypeId;
    }

    public void setSectionTypeId(Integer sectionTypeId) {
        this.sectionTypeId = sectionTypeId;
    }

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
