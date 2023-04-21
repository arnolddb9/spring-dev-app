package com.pfcti.spring.dev.app.repository;


import com.pfcti.spring.dev.app.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetaRepository extends JpaRepository<Tarjeta,Integer> {
    void deleteAllByCliente_id(int clienteId);
}
