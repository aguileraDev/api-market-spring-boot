package com.platzimarket.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author aguileradev
 */
@Data
@Embeddable
public class BuyProductPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_compra", nullable = false)
    private Integer idCompra;

    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;
}
