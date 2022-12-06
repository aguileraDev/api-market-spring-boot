package com.platzimarket.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 * @author aguileradev
 */

@Data
@Entity
@Table(name = "productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "id_categoria", nullable = false)
    private Integer idCategoria;

    @Column(name ="codigo_barras", length = 150)
    private String codigoBarras;

    @Column(name = "precio_venta", length = 16)
    private Double precioVenta;

    @Column(name = "cantidad_stock", nullable = false)
    private Integer cantidadStock;

    @Column(name = "estado")
    private Boolean estado;

    /*Creando relacion con categorias*/

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Category categoria;


}
