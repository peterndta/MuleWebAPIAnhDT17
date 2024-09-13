package com.anhndt17.purchase_order_service.entity;

import java.io.Serializable;
import java.util.Objects;

public class PurchaseOrderDetailId implements Serializable {
    private String orderNo;
    private String productCode;
    private Double purchasePrice;

    // Default constructor
    public PurchaseOrderDetailId() {
    }

    // Parameterized constructor
    public PurchaseOrderDetailId(String orderNo, String productCode, Double purchasePrice) {
        this.orderNo = orderNo;
        this.productCode = productCode;
        this.purchasePrice = purchasePrice;
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

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    // hashCode() and equals() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrderDetailId that = (PurchaseOrderDetailId) o;
        return Objects.equals(orderNo, that.orderNo) &&
                Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo, productCode);
    }
}
