package com.platzimarket.domain.repository;

import com.platzimarket.domain.ProductMap;
import com.platzimarket.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author aguileradev
 */
public interface ProductMapRepository {

    List<ProductMap> getAll();
    Optional<List<ProductMap>> getByCategory(int categoryId);
    Optional<List<ProductMap>> getLowStock(int quantity);
    Optional<ProductMap> getProduct(int productId);
    ProductMap save(ProductMap productMap);
    void deleteById(int productId);
}
