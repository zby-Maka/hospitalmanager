package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "proposed_description", schema = "health_examination_system", catalog = "")
public class ProposedDescription {
    private int proposedDescriptionId;
    private Integer resultId;
    private String sciencePopularization;
    private String adviceContent;
    private Integer isDelete;

    @Id
    @Column(name = "proposed_description_id")
    public int getProposedDescriptionId() {
        return proposedDescriptionId;
    }

    public void setProposedDescriptionId(int proposedDescriptionId) {
        this.proposedDescriptionId = proposedDescriptionId;
    }

    @Basic
    @Column(name = "result_id")
    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    @Basic
    @Column(name = "science_popularization")
    public String getSciencePopularization() {
        return sciencePopularization;
    }

    public void setSciencePopularization(String sciencePopularization) {
        this.sciencePopularization = sciencePopularization;
    }

    @Basic
    @Column(name = "advice_content")
    public String getAdviceContent() {
        return adviceContent;
    }

    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent;
    }

    @Basic
    @Column(name = "is_delete")
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProposedDescription that = (ProposedDescription) o;
        return proposedDescriptionId == that.proposedDescriptionId &&
                Objects.equals(resultId, that.resultId) &&
                Objects.equals(sciencePopularization, that.sciencePopularization) &&
                Objects.equals(adviceContent, that.adviceContent) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(proposedDescriptionId, resultId, sciencePopularization, adviceContent, isDelete);
    }
}
