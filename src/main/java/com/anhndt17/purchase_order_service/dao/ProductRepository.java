package com.anhndt17.purchase_order_service.dao;

import com.anhndt17.purchase_order_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String>, ProductDAO {
}
