package com.pfcti.spring.dev.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="TCLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nombre")
    private  String nombre;
    @Column(length = 30)
    private String apellido;
    @Column(columnDefinition = "varchar(15)")
    private String cedula;
    @Column
    private String telefono;


}
