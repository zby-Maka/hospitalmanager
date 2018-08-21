package com.dyhc.hospitalmanager.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cost_detail", schema = "health_examination_system", catalog = "")
public class CostDetail {
    private int costDetailId;
    private Integer checkId;
    private BigDecimal costDetailPrice;
    private Integer costId;

    @Id
    @Column(name = "cost_detail_id")
    public int getCostDetailId() {
        return costDetailId;
    }

    public void setCostDetailId(int costDetailId) {
        this.costDetailId = costDetailId;
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
    @Column(name = "cost_detail_price")
    public BigDecimal getCostDetailPrice() {
        return costDetailPrice;
    }

    public void setCostDetailPrice(BigDecimal costDetailPrice) {
        this.costDetailPrice = costDetailPrice;
    }

    @Basic
    @Column(name = "cost_id")
    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostDetail that = (CostDetail) o;
        return costDetailId == that.costDetailId &&
                Objects.equals(checkId, that.checkId) &&
                Objects.equals(costDetailPrice, that.costDetailPrice) &&
                Objects.equals(costId, that.costId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(costDetailId, checkId, costDetailPrice, costId);
    }
}
