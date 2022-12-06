package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.PurchaseItem;
import com.platzimarket.persistence.entity.BuyProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author aguileradev
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto",target = "productId"),
            @Mapping(source = "cantidad",target = "quantity"),
            @Mapping(source = "total",target = "total"),
            @Mapping(source = "estado",target = "active"),

    })
    PurchaseItem toPurchaseItem(BuyProduct buyProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.idCompra", ignore = true),
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true)
    })
    BuyProduct toBuyProduct(PurchaseItem purchaseItem);
}
