package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class ProposedDescription {
    private Integer proposedDescriptionId;
    private Integer resultId;
    private String sciencePopularization;
    private String adviceContent;
    private Integer isDelete;

    public Integer getProposedDescriptionId() {
        return proposedDescriptionId;
    }

    public void setProposedDescriptionId(Integer proposedDescriptionId) {
        this.proposedDescriptionId = proposedDescriptionId;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public String getSciencePopularization() {
        return sciencePopularization;
    }

    public void setSciencePopularization(String sciencePopularization) {
        this.sciencePopularization = sciencePopularization;
    }

    public String getAdviceContent() {
        return adviceContent;
    }

    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent;
    }

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
