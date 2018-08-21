package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "common_results", schema = "health_examination_system", catalog = "")
public class CommonResults {
    private int commonResultsId;
    private Integer checkId;
    private String resultDesc;
    private String pinyinCod;
    private Integer isPositive;
    private Integer isDelete;

    @Id
    @Column(name = "common_results_id")
    public int getCommonResultsId() {
        return commonResultsId;
    }

    public void setCommonResultsId(int commonResultsId) {
        this.commonResultsId = commonResultsId;
    }

    @Basic
    @Column(name = "check_id")
    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    @Basic
    @Column(name = "result_desc")
    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    @Basic
    @Column(name = "pinyin_cod")
    public String getPinyinCod() {
        return pinyinCod;
    }

    public void setPinyinCod(String pinyinCod) {
        this.pinyinCod = pinyinCod;
    }

    @Basic
    @Column(name = "is_positive")
    public Integer getIsPositive() {
        return isPositive;
    }

    public void setIsPositive(Integer isPositive) {
        this.isPositive = isPositive;
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
