package com.anhndt17.purchase_order_service.dao;

public interface ProductDAO {
    void updateProductAfterPurchase(String productCode, Double quantity, Double purchasePrice);
    void updateProductAfterSales(String productCode, Double quantity);
}
