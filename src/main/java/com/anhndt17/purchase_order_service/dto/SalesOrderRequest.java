package com.anhndt17.purchase_order_service.dto;

import com.anhndt17.purchase_order_service.entity.SalesOrder;
import com.anhndt17.purchase_order_service.entity.SalesOrderDetail;

import java.util.List;

public class SalesOrderRequest {
    private SalesOrder order;
    private List<SalesOrderDetail> details;

    // Getters and Setters
    public SalesOrder getOrder() {
        return order;
    }

    public void setOrder(SalesOrder order) {
        this.order = order;
    }

    public List<SalesOrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<SalesOrderDetail> details) {
        this.details = details;
    }
}
