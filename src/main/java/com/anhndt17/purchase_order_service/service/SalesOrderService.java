package com.anhndt17.purchase_order_service.service;

import com.anhndt17.purchase_order_service.entity.SalesOrder;
import com.anhndt17.purchase_order_service.entity.SalesOrderDetail;

import java.util.List;

public interface SalesOrderService {
    void insertSalesOrderAndDetails(SalesOrder order, List<SalesOrderDetail> details);
    SalesOrder getSalesOrderById(String orderNo);
    List<SalesOrder> getAllSalesOrders();
}
