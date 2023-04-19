package com.pfcti.spring.dev.app.repository;


import com.pfcti.spring.dev.app.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion,Integer> {
}
