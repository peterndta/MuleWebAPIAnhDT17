package com.anhndt17.purchase_order_service.service;

import com.anhndt17.purchase_order_service.dto.PurchaseOrderResponse;
import com.anhndt17.purchase_order_service.entity.PurchaseOrder;
import com.anhndt17.purchase_order_service.entity.PurchaseOrderDetail;

import java.util.List;

public interface PurchaseOrderService {
    void insertPurchaseOrderAndDetails(PurchaseOrder order, List<PurchaseOrderDetail> details);
    PurchaseOrder getPurchaseOrderById(String orderNo);
    List<PurchaseOrder> getAllPurchaseOrders();
}
