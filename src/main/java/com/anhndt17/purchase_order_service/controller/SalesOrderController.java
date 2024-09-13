package com.anhndt17.purchase_order_service.controller;

import com.anhndt17.purchase_order_service.dto.ErrorResponse;
import com.anhndt17.purchase_order_service.dto.PurchaseOrderResponse;
import com.anhndt17.purchase_order_service.dto.SalesOrderRequest;
import com.anhndt17.purchase_order_service.dto.SalesOrderResponse;
import com.anhndt17.purchase_order_service.entity.SalesOrder;
import com.anhndt17.purchase_order_service.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-orders")
public class SalesOrderController {

    private SalesOrderService salesOrderService;

    @Autowired
    public SalesOrderController(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    @PostMapping
    public ResponseEntity<?> createSalesOrder(@RequestBody SalesOrderRequest request) {
        try {
            salesOrderService.insertSalesOrderAndDetails(request.getOrder(), request.getDetails());

            SalesOrderResponse response = new SalesOrderResponse();
            response.setStatus("success");
            response.setMessage("Sales order and details created successfully.");

            SalesOrderResponse.SalesOrderData data = new SalesOrderResponse.SalesOrderData();
            data.setOrder(request.getOrder());
            data.setDetails(request.getDetails());

            response.setData(data);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("error", "An error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // Get details of a specific sales order by order number
    @GetMapping("/{orderNo}")
    public SalesOrder getSalesOrder(@PathVariable String orderNo) {
        return salesOrderService.getSalesOrderById(orderNo);
    }

    // Get all sales orders
    @GetMapping
    public List<SalesOrder> getAllSalesOrders() {
        return salesOrderService.getAllSalesOrders();
    }
}
