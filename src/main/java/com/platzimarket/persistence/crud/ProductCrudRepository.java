package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author aguileradev
 */
public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    List<Product> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Product>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);


}
