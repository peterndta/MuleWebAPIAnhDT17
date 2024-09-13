package com.anhndt17.purchase_order_service.dao;

import com.anhndt17.purchase_order_service.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, String> {
}