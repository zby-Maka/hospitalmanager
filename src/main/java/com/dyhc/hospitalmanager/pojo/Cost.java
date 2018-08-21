package com.dyhc.hospitalmanager.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Cost {
    private int costId;
    private String costType;
    private String healthExaminationId;
    private BigDecimal costAmount;
    private Timestamp costDate;

    @Id
    @Column(name = "cost_id")
    public int getCostId() {
        return costId;
    }

    public void setCostId(int costId) {
        this.costId = costId;
    }

    @Basic
    @Column(name = "cost_type")
    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    @Basic
    @Column(name = "health_examination_id")
    public String getHealthExaminationId() {
        return healthExaminationId;
    }

    public void setHealthExaminationId(String healthExaminationId) {
        this.healthExaminationId = healthExaminationId;
    }

    @Basic
    @Column(name = "cost_amount")
    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    @Basic
    @Column(name = "cost_date")
    public Timestamp getCostDate() {
        return costDate;
    }

    public void setCostDate(Timestamp costDate) {
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
