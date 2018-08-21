package com.dyhc.hospitalmanager.pojo;

import java.math.BigDecimal;
import java.util.Objects;

public class CostDetail {
    private Integer costDetailId;
    private Integer checkId;
    private BigDecimal costDetailPrice;
    private Integer costId;

    public Integer getCostDetailId() {
        return costDetailId;
    }

    public void setCostDetailId(Integer costDetailId) {
        this.costDetailId = costDetailId;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public BigDecimal getCostDetailPrice() {
        return costDetailPrice;
    }

    public void setCostDetailPrice(BigDecimal costDetailPrice) {
        this.costDetailPrice = costDetailPrice;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(costDetailId, checkId, costDetailPrice, costId);
    }
}
