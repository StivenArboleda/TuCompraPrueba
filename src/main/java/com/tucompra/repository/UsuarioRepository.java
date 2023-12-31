package com.tucompra.repository;

import com.tucompra.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByDocumentoIdentificacion(String documentoIdentificacion);


}
