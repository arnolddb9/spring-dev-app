package com.pfcti.spring.dev.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="TINVERSION")
public class Inversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private  String numero;
    @Column
    private String  tipo;

    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private Cliente cliente;
}
