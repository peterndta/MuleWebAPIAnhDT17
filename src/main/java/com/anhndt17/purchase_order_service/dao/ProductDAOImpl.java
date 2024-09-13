package com.anhndt17.purchase_order_service.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDAOImpl implements ProductDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void updateProductAfterPurchase(String productCode, Double quantity, Double purchasePrice) {
        String jpql = "UPDATE Product p " +
                "SET p.quantityInStock = p.quantityInStock + :quantity, " +
                "p.unitPrice = (p.quantityInStock * p.unitPrice + :quantity * :purchasePrice) / (p.quantityInStock + :quantity) " +
                "WHERE p.productCode = :productCode";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("productCode", productCode);
        query.setParameter("quantity", quantity);
        query.setParameter("purchasePrice", purchasePrice);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateProductAfterSales(String productCode, Double quantity) {
        String jpql = "UPDATE Product p SET p.quantityInStock = p.quantityInStock + :quantity " +
                "WHERE p.productCode = :productCode";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("quantity", quantity);
        query.setParameter("productCode", productCode);
        query.executeUpdate();
    }
}
