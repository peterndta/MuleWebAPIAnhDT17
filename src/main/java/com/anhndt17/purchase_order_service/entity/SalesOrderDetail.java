package com.anhndt17.purchase_order_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SalesOrderDetails")
@IdClass(SalesOrderDetailId.class)
public class SalesOrderDetail {
    @Id
    @Column(name = "OrderNo", length = 6)
    private String orderNo;

    @Id
    @Column(name = "ProductCode", length = 6)
    private String productCode;

    @Id
    @Column(name = "SalesPrice")
    private Double salesPrice;

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

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
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
