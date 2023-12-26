package com.tucompra.repository;

import com.tucompra.model.HistoriaClinica;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {


    @Modifying
    @Transactional
    @Query("DELETE FROM HistoriaClinica h WHERE h.mascota.usuario.id = :usuarioId")
    void deleteByMascotaUsuarioId(@Param("usuarioId") Long usuarioId);


}
