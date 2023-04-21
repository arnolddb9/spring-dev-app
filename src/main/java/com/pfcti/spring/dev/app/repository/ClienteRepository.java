package com.pfcti.spring.dev.app.repository;

import com.pfcti.spring.dev.app.model.Cliente;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    List<Cliente> findClientesByPaisAndCuentas_EstadoIsTrue(String pais);
    @Query(value = "select c from Cliente c where c.apellido=:apellido")
    List<Cliente> buscarPorApellido(String apellido);

    @Query(value = "SELECT id, nombre, apellido, cedula, telefono FROM TCLIENTE WHERE apellido=:apellido", nativeQuery = true)
    List<Tuple> buscarPorApellidosQueryNativo(String apellido);

    @Modifying
    @Query(value = "update Cliente c set c.nombre=:nombre where  c.apellido=:apellido")
    void updateClienteByQuery(String nombre, String apellido);

}
