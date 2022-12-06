package com.platzimarket.domain;

import lombok.Data;

/**
 * @author aguileradev
 */
@Data
public class PurchaseItem {

    private int productId;
    private int quantity;
    private double total;
    private Boolean active;


}
