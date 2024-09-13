package com.anhndt17.purchase_order_service.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

public class SalesOrderDetailId  implements Serializable {
    private String orderNo;
    private String productCode;
    private Double salesPrice;

    // Default constructor
    public SalesOrderDetailId() {
    }

    // Parameterized constructor
    public SalesOrderDetailId(String orderNo, String productCode, Double salesPrice) {
        this.orderNo = orderNo;
        this.productCode = productCode;
        this.salesPrice = salesPrice;
    }

    // Getters and Setters
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    // hashCode() and equals() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesOrderDetailId that = (SalesOrderDetailId) o;
        return Objects.equals(orderNo, that.orderNo) &&
                Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo, productCode);
    }
}
