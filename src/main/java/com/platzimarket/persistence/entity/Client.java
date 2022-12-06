package com.platzimarket.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author aguileradev
 */

@Data
@Entity
@Table(name = "clientes")
public class Client {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "celular", length = 20)
    private Long celular;

    @Column(name = "direccion", length = 80)
    private String direccion;

    @Column(name = "correo_electronico", length = 70)
    private String correoElectronico;

    /*Relacion con compras*/
    @OneToMany(mappedBy = "cliente")
    private List<Buy> compras;
}
