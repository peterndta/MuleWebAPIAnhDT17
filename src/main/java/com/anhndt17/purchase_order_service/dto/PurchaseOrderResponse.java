package com.anhndt17.purchase_order_service.dto;

import com.anhndt17.purchase_order_service.entity.PurchaseOrder;
import com.anhndt17.purchase_order_service.entity.PurchaseOrderDetail;

import java.util.List;

public class PurchaseOrderResponse {
    private String status;
    private String message;
    private PurchaseOrderData data;

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PurchaseOrderData getData() {
        return data;
    }

    public void setData(PurchaseOrderData data) {
        this.data = data;
    }

    public static class PurchaseOrderData {
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
}

