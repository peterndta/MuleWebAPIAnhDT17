package com.anhndt17.purchase_order_service.dao;

import com.anhndt17.purchase_order_service.entity.PurchaseOrderDetail;
import com.anhndt17.purchase_order_service.entity.PurchaseOrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderDetailRepository extends JpaRepository<PurchaseOrderDetail, PurchaseOrderDetailId> {
}
