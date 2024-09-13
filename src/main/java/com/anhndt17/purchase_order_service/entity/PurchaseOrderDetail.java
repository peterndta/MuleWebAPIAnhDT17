package com.anhndt17.purchase_order_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PurchaseOrderDetails")
@IdClass(PurchaseOrderDetailId.class)
public class PurchaseOrderDetail {
    @Id
    @Column(name = "OrderNo", length = 6)
    private String orderNo;

    @Id
    @Column(name = "ProductCode", length = 6)
    private String productCode;

    @Id
    @Column(name = "PurchasePrice")
    private Double purchasePrice;

    @Column(name = "Quantity")
    private Double quantity;

    @Column(name = "Tax")
    private Double tax;

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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
}
