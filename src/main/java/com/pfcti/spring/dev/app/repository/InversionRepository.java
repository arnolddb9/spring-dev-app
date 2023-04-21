package com.pfcti.spring.dev.app.repository;


import com.pfcti.spring.dev.app.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InversionRepository extends JpaRepository<Inversion,Integer> {
    void deleteAllByCliente_id(int clienteId);
}
