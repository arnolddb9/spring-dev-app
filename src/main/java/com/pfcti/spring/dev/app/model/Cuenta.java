package com.pfcti.spring.dev.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="TCUENTA")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private  String numero;
    @Column
    private String  tipo;
    @Column
    private Boolean  estado;

    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private Cliente cliente;

}
