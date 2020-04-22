package com.example.sapo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="loyaltycard")
public class LoyaltyCard {
    private int id;
    private String code;
    private Integer customerPhonenumber;
    private double point;
    private double revenue;
    private Date beginDate;
    private Date endDate;
    private Date createdAt;
    private Date updatedAt;
    private Integer loyaltycardtypeId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "customer_phonenumber")
    public Integer getCustomerPhonenumber() {
        return customerPhonenumber;
    }

    public void setCustomerPhonenumber(Integer customerPhonenumber) {
        this.customerPhonenumber = customerPhonenumber;
    }

    @Basic
    @Column(name = "point")
    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Basic
    @Column(name = "revenue")
    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    @Basic
    @Column(name = "begin_date")
    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoyaltyCard that = (LoyaltyCard) o;
        return id == that.id &&
                Double.compare(that.point, point) == 0 &&
                Double.compare(that.revenue, revenue) == 0 &&
                Objects.equals(code, that.code) &&
                Objects.equals(customerPhonenumber, that.customerPhonenumber) &&
                Objects.equals(beginDate, that.beginDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, customerPhonenumber, point, revenue, beginDate, endDate, createdAt, updatedAt);
    }

    @Basic
    @Column(name = "loyaltycardtype_id")
    public Integer getLoyaltycardtypeId() {
        return loyaltycardtypeId;
    }

    public void setLoyaltycardtypeId(Integer loyaltycardtypeId) {
        this.loyaltycardtypeId = loyaltycardtypeId;
    }
}
