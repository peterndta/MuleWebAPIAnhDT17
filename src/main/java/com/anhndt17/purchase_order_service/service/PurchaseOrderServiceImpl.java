package com.anhndt17.purchase_order_service.service;

import com.anhndt17.purchase_order_service.dao.ProductDAO;
import com.anhndt17.purchase_order_service.dao.ProductRepository;
import com.anhndt17.purchase_order_service.dao.PurchaseOrderDetailRepository;
import com.anhndt17.purchase_order_service.dao.PurchaseOrderRepository;
import com.anhndt17.purchase_order_service.entity.PurchaseOrder;
import com.anhndt17.purchase_order_service.entity.PurchaseOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService{
    //--------Field Injection
//    @Autowired
//    private PurchaseOrderRepository purchaseOrderRepository;
//
//    @Autowired
//    private PurchaseOrderDetailRepository purchaseOrderDetailRepository;

//    @Autowired
//    private ProductDAO productDAO;
//@Autowired
//    private ProductRepository productRepository;

    //------Constructor Injection
    private PurchaseOrderRepository purchaseOrderRepository;
    private PurchaseOrderDetailRepository purchaseOrderDetailRepository;
    private ProductRepository productRepository;

    @Autowired
    public PurchaseOrderServiceImpl(
            PurchaseOrderRepository purchaseOrderRepository,
            PurchaseOrderDetailRepository purchaseOrderDetailRepository,
            ProductRepository productRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.purchaseOrderDetailRepository = purchaseOrderDetailRepository;
        this.productRepository = productRepository;
    }


    @Override
    @Transactional
    public void insertPurchaseOrderAndDetails(PurchaseOrder order, List<PurchaseOrderDetail> details) {
        purchaseOrderRepository.save(order); // Save the PurchaseOrder

        for (PurchaseOrderDetail detail : details) {
            purchaseOrderDetailRepository.save(detail); // Save each PurchaseOrderDetail

            // Update product quantity and price based on purchase
            productRepository.updateProductAfterPurchase(
                    detail.getProductCode(),
                    detail.getQuantity(),
                    detail.getPurchasePrice()
            );
        }
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(String orderNo) {
        return purchaseOrderRepository.findById(orderNo).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }
}
