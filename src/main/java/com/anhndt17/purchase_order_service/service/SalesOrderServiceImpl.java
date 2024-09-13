package com.anhndt17.purchase_order_service.service;

import com.anhndt17.purchase_order_service.dao.*;
import com.anhndt17.purchase_order_service.entity.SalesOrder;
import com.anhndt17.purchase_order_service.entity.SalesOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {
    //--------Field Injection
//    @Autowired
//    private SalesOrderRepository salesOrderRepository;
//
//    @Autowired
//    private SalesOrderDetailRepository salesOrderDetailRepository;

//    @Autowired
//    private ProductDAO productDAO;

//    @Autowired
//    private ProductRepository productRepository;

    //------Constructor Injection
    private SalesOrderRepository salesOrderRepository;
    private SalesOrderDetailRepository salesOrderDetailRepository;
    private ProductRepository productRepository;

    @Autowired
    public SalesOrderServiceImpl(
            SalesOrderRepository salesOrderRepository,
            SalesOrderDetailRepository salesOrderDetailRepository,
            ProductRepository productRepository) {
        this.salesOrderRepository = salesOrderRepository;
        this.salesOrderDetailRepository = salesOrderDetailRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void insertSalesOrderAndDetails(SalesOrder order, List<SalesOrderDetail> details) {
        salesOrderRepository.save(order); // Save the SalesOrder

        for (SalesOrderDetail detail : details) {
            salesOrderDetailRepository.save(detail); // Save each SalesOrderDetail

            // Update product quantity based on sales
            productRepository.updateProductAfterSales(
                    detail.getProductCode(),
                    detail.getQuantity()
            );
        }
    }

    @Override
    public SalesOrder getSalesOrderById(String orderNo) {
        return salesOrderRepository.findById(orderNo).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<SalesOrder> getAllSalesOrders() {
        return salesOrderRepository.findAll();
    }
}