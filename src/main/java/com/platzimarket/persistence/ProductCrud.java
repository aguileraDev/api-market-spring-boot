package com.platzimarket.persistence;

import com.platzimarket.domain.ProductMap;
import com.platzimarket.domain.repository.ProductMapRepository;
import com.platzimarket.persistence.crud.ProductCrudRepository;
import com.platzimarket.persistence.entity.Product;
import com.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author aguileradev
 */
@Repository
public class ProductCrud implements ProductMapRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductMap> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProductMaps(products);
    }
    @Override
    public Optional<List<ProductMap>> getByCategory(int categoryId){
        List<Product> products = productCrudRepository.
                findByIdCategoriaOrderByNombreAsc(categoryId);

        return Optional.of(mapper.toProductMaps(products));
    }

    @Override
    public Optional<List<ProductMap>> getLowStock(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return products.map((prod) -> mapper.toProductMaps(prod));
    }

    @Override
    public Optional<ProductMap> getProduct(int productId){
        return productCrudRepository.findById(productId).map(prod -> mapper.toProductMap(prod));

    }

    @Override
    public ProductMap save(ProductMap productMap) {
        Product product = mapper.toProduct(productMap);
        return mapper.toProductMap(productCrudRepository.save(product));
    }

    @Override
    public void deleteById(int productId){
        productCrudRepository.deleteById(productId);
    }

}
