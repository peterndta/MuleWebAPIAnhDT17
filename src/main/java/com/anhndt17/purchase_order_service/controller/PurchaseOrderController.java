package com.anhndt17.purchase_order_service.controller;

import com.anhndt17.purchase_order_service.dto.ErrorResponse;
import com.anhndt17.purchase_order_service.dto.PurchaseOrderRequest;
import com.anhndt17.purchase_order_service.dto.PurchaseOrderResponse;
import com.anhndt17.purchase_order_service.entity.PurchaseOrder;
import com.anhndt17.purchase_order_service.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    private PurchaseOrderService purchaseOrderService;

    @Autowired
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @PostMapping
    public ResponseEntity<?> createPurchaseOrder(@RequestBody PurchaseOrderRequest request) {
        try {
            purchaseOrderService.insertPurchaseOrderAndDetails(request.getOrder(), request.getDetails());

            PurchaseOrderResponse response = new PurchaseOrderResponse();
            response.setStatus("success");
            response.setMessage("Purchase order and details created successfully.");

            PurchaseOrderResponse.PurchaseOrderData data = new PurchaseOrderResponse.PurchaseOrderData();
            data.setOrder(request.getOrder());
            data.setDetails(request.getDetails());

            response.setData(data);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("error", "An error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // Get details of a specific purchase order by order number
    @GetMapping("/{orderNo}")
    public PurchaseOrder getPurchaseOrder(@PathVariable String orderNo) {
        return purchaseOrderService.getPurchaseOrderById(orderNo);
    }

    // Get all purchase orders
    @GetMapping
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderService.getAllPurchaseOrders();
    }
}