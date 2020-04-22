package com.example.sapo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="transaction")
public class Transaction {
    private int id;
    private double pointAdjust;
    private double spentAdjust;
    private Date createdAt;
    private int configId;
    private int loyaltycardId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "point_adjust")
    public double getPointAdjust() {
        return pointAdjust;
    }

    public void setPointAdjust(double pointAdjust) {
        this.pointAdjust = pointAdjust;
    }

    @Basic
    @Column(name = "spent_adjust")
    public double getSpentAdjust() {
        return spentAdjust;
    }

    public void setSpentAdjust(double spentAdjust) {
        this.spentAdjust = spentAdjust;
    }

    @Basic
    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id &&
                Double.compare(that.pointAdjust, pointAdjust) == 0 &&
                Double.compare(that.spentAdjust, spentAdjust) == 0 &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pointAdjust, spentAdjust, createdAt);
    }

    @Basic
    @Column(name = "config_id")
    public int getConfigId() {
        return configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    @Basic
    @Column(name = "loyaltycard_id")
    public int getLoyaltycardId() {
        return loyaltycardId;
    }

    public void setLoyaltycardId(int loyaltycardId) {
        this.loyaltycardId = loyaltycardId;
    }
}
