package com.dyhc.hospitalmanager.pojo;

import java.util.Objects;

public class CommonResults {
    private Integer commonResultsId;
    private Integer checkId;
    private String resultDesc;
    private String pinyinCod;
    private Integer isPositive;
    private Integer isDelete;

    public ProposedDescription getProposedDescription() {
        return proposedDescription;
    }

    public void setProposedDescription(ProposedDescription proposedDescription) {
        this.proposedDescription = proposedDescription;
    }

    private  ProposedDescription proposedDescription;

    public Integer getCommonResultsId() {
        return commonResultsId;
    }

    public void setCommonResultsId(Integer commonResultsId) {
        this.commonResultsId = commonResultsId;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getPinyinCod() {
        return pinyinCod;
    }

    public void setPinyinCod(String pinyinCod) {
        this.pinyinCod = pinyinCod;
    }

    public Integer getIsPositive() {
        return isPositive;
    }

    public void setIsPositive(Integer isPositive) {
        this.isPositive = isPositive;
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
        CommonResults that = (CommonResults) o;
        return commonResultsId == that.commonResultsId &&
                Objects.equals(checkId, that.checkId) &&
                Objects.equals(resultDesc, that.resultDesc) &&
                Objects.equals(pinyinCod, that.pinyinCod) &&
                Objects.equals(isPositive, that.isPositive) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(commonResultsId, checkId, resultDesc, pinyinCod, isPositive, isDelete);
    }
}
