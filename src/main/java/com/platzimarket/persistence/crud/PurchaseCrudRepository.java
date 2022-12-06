package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.Buy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author aguileradev
 */
public interface PurchaseCrudRepository extends CrudRepository<Buy, Integer> {
    Optional<List<Buy>> findByIdCliente(String idCliente);
}
