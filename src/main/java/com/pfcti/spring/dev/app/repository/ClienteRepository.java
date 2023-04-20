package com.pfcti.spring.dev.app.repository;

import com.pfcti.spring.dev.app.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    List<Cliente> findClientesByPaisAndCuentas_EstadoIsTrue(String pais);
}
