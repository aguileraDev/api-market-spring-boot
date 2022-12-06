package com.platzimarket.persistence;

/**
 * @author aguileradev
 */

import com.platzimarket.domain.Purchase;
import com.platzimarket.domain.repository.PurchaseRepository;
import com.platzimarket.persistence.crud.PurchaseCrudRepository;
import com.platzimarket.persistence.entity.Buy;
import com.platzimarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseCrud implements PurchaseRepository {

    @Autowired
    private PurchaseCrudRepository repository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toListPurchase((List<Buy> )repository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return repository.findByIdCliente(clientId)
                .map(client -> mapper.toListPurchase(client));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Buy buy = mapper.toBuy(purchase);
        buy.getProductos().forEach(product -> product.setCompra(buy));
        return mapper.toPurchase(repository.save(buy));
    }
}
