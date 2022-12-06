package com.platzimarket.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;

/**
 * @author aguileradev
 */
@Data
@Entity
@Table(name = "compras_productos")
public class BuyProduct {

    @EmbeddedId
    private BuyProductPK id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "total")
    private Double total;

    /*Relacion con compras*/

    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Buy compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product producto;
}
