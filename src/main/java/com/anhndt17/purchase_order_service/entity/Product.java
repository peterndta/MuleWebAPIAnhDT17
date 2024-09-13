package com.anhndt17.purchase_order_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @Column(name = "ProductCode", length = 6)
    private String productCode;

    @Column(name = "ProductName", length = 150)
    private String productName;

    @Column(name = "Unit", length = 20)
    private String unit;

    @Column(name = "QuantityInStock")
    private Double quantityInStock;

    @Column(name = "UnitPrice")
    private Double unitPrice;

    @Column(name = "CreatedByDate")
    private Date createdByDate;

    @Column(name = "CreatedBy", length = 20)
    private String createdBy;

    // Getters and Setters
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Double quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getCreatedByDate() {
        return createdByDate;
    }

    public void setCreatedByDate(Date createdByDate) {
        this.createdByDate = createdByDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}

