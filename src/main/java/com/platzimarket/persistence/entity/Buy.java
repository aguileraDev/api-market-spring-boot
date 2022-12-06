package com.platzimarket.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author aguileradev
 */
@Data
@Entity
@Table(name = "compras")
public class Buy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra", nullable = false)
    private Integer idCompra;

    @Column(name = "id_cliente", nullable = false)
    private String idCliente;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "estado")
    private String estado;

    /*Relacion con clientes*/

    @ManyToOne
    @JoinColumn(name ="id_cliente", insertable = false, updatable = false)
    private Client cliente;

    /*Relacion con compras_productos*/
    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
    private List<BuyProduct> productos;
}
