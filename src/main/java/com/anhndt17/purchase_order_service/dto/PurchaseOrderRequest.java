package com.anhndt17.purchase_order_service.dto;

import com.anhndt17.purchase_order_service.entity.PurchaseOrder;
import com.anhndt17.purchase_order_service.entity.PurchaseOrderDetail;

import java.util.List;

public class PurchaseOrderRequest {
    private PurchaseOrder order;
    private List<PurchaseOrderDetail> details;

    // Getters and Setters
    public PurchaseOrder getOrder() {
        return order;
    }

    public void setOrder(PurchaseOrder order) {
        this.order = order;
    }

    public List<PurchaseOrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<PurchaseOrderDetail> details) {
        this.details = details;
    }
}
