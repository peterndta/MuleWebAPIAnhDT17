package com.anhndt17.purchase_order_service.dto;

import com.anhndt17.purchase_order_service.entity.SalesOrder;
import com.anhndt17.purchase_order_service.entity.SalesOrderDetail;

import java.util.List;

public class SalesOrderResponse {
    private String status;
    private String message;
    private SalesOrderData data;

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

    public SalesOrderData getData() {
        return data;
    }

    public void setData(SalesOrderData data) {
        this.data = data;
    }

    public static class SalesOrderData {
        private SalesOrder order;
        private List<SalesOrderDetail> details;

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
}
