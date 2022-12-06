package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.CategoryMap;
import com.platzimarket.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author aguileradev
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target ="categoryId" ),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    CategoryMap toCategoryMap (Category category);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Category toCategory(CategoryMap categoryMap);
}
