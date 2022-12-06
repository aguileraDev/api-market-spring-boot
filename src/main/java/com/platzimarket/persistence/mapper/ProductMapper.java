package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.ProductMap;
import com.platzimarket.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author aguileradev
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto" , target = "productId"),
            @Mapping(source = "nombre" , target = "name"),
            @Mapping(source = "idCategoria" , target = "categoryId"),
            @Mapping(source = "precioVenta" , target = "price"),
            @Mapping(source = "cantidadStock" , target = "stock"),
            @Mapping(source = "estado" , target = "active"),
            @Mapping(source = "categoria" , target = "category"),
    })
    ProductMap toProductMap(Product product);
    List<ProductMap> toProductMaps(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Product toProduct(ProductMap productMap);
}
