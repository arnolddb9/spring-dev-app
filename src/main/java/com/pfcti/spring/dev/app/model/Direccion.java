package com.pfcti.spring.dev.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="TDIRECCION")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private  String direccion;
    @Column
    private String  nomeclatura;

    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private Cliente cliente;

}
