package com.dyhc.hospitalmanager.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


public class Cost {
    private Integer costId;
    private String costType;
    private String healthExaminationId;
    private BigDecimal costAmount;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date costDate;

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getHealthExaminationId() {
        return healthExaminationId;
    }

    public void setHealthExaminationId(String healthExaminationId) {
        this.healthExaminationId = healthExaminationId;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public Date getCostDate() {
        return costDate;
    }

    public void setCostDate(Date costDate) {
        this.costDate = costDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost = (Cost) o;
        return costId == cost.costId &&
                Objects.equals(costType, cost.costType) &&
                Objects.equals(healthExaminationId, cost.healthExaminationId) &&
                Objects.equals(costAmount, cost.costAmount) &&
                Objects.equals(costDate, cost.costDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(costId, costType, healthExaminationId, costAmount, costDate);
    }
}
