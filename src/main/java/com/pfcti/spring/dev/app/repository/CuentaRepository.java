package com.pfcti.spring.dev.app.repository;


import com.pfcti.spring.dev.app.model.Cliente;
import com.pfcti.spring.dev.app.model.Cuenta;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface CuentaRepository extends JpaRepository<Cuenta,Integer>, JpaSpecificationExecutor<Cuenta> {
    void deleteAllByCliente_id(int clienteId);


}
