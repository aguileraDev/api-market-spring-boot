package com.platzimarket.domain;

import lombok.Data;

/**
 * @author aguileradev
 */
@Data
public class ProductMap {

    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private CategoryMap category;
}
