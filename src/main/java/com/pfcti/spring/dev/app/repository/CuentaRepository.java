package com.pfcti.spring.dev.app.repository;


import com.pfcti.spring.dev.app.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta,Integer> {
}
