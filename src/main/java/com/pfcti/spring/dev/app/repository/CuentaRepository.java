package com.pfcti.spring.dev.app.repository;



import com.pfcti.spring.dev.app.model.Cuenta;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CuentaRepository extends JpaRepository<Cuenta,Integer>, JpaSpecificationExecutor<Cuenta> {
    void deleteAllByCliente_id(int clienteId);
    @Modifying
    @Query(value = "update Cuenta c set c.estado=:estado where  c.numero=:numero")
    void updateCuentaEstadoByNumeroQuery(String numero, Boolean estado);

    List<Cuenta> findCuentaByCliente_Id(int idCliente );
}
