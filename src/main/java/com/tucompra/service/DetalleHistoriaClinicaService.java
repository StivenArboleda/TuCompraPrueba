package com.tucompra.service;

import com.tucompra.helpers.ClinicaExcepcion;
import com.tucompra.model.DetalleHistoriaClinica;
import com.tucompra.model.HistoriaClinica;
import com.tucompra.repository.DetalleHistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleHistoriaClinicaService {

    @Autowired
    private DetalleHistoriaClinicaRepository detalleHistoriaClinicaRepository;

    public List<DetalleHistoriaClinica> getAllDetallesHistoriaClinica() {
        return detalleHistoriaClinicaRepository.findAll();
    }

    public DetalleHistoriaClinica getDetalleHistoriaClinicaById(Long id) {
        return detalleHistoriaClinicaRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el detalle de historia clínica con ID: " + id));
    }

    public DetalleHistoriaClinica saveDetalleHistoriaClinica(DetalleHistoriaClinica detalleHistoriaClinica) {
        return detalleHistoriaClinicaRepository.save(detalleHistoriaClinica);
    }

    public void deleteDetalleHistoriaClinica(Long id) {
        detalleHistoriaClinicaRepository.deleteById(id);
    }
}
