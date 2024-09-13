package com.anhndt17.purchase_order_service.dao;

import com.anhndt17.purchase_order_service.entity.SalesOrderDetail;
import com.anhndt17.purchase_order_service.entity.SalesOrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderDetailRepository extends JpaRepository<SalesOrderDetail, SalesOrderDetailId> {
}