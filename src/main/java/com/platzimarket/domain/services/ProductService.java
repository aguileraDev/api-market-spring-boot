package com.platzimarket.domain.services;

import com.platzimarket.domain.ProductMap;
import com.platzimarket.domain.repository.ProductMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author aguileradev
 */
@Service
public class ProductService {

    @Autowired
    private ProductMapRepository productRepository;

    public List<ProductMap> getAll(){
        return productRepository.getAll();
    }

    public Optional<List<ProductMap>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<ProductMap>> getLowStock(int quantity){
        return productRepository.getLowStock(quantity);
    }

    public Optional<ProductMap> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public ProductMap save(ProductMap productMap){
        return productRepository.save(productMap);
    }

    public Boolean delete(int productId){
        return getProduct(productId).map((prod) -> {
            productRepository.deleteById(productId);
            return true;
        }).orElse(false);
    }
}
