package com.tucompra.service;

import com.tucompra.helpers.ClinicaExcepcion;
import com.tucompra.model.Colaborador;
import com.tucompra.model.DetalleHistoriaClinica;
import com.tucompra.model.HistoriaClinica;
import com.tucompra.repository.ColaboradorRepository;
import com.tucompra.repository.DetalleHistoriaClinicaRepository;
import com.tucompra.repository.HistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleHistoriaClinicaService {

    @Autowired
    private DetalleHistoriaClinicaRepository detalleHistoriaClinicaRepository;

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<DetalleHistoriaClinica> getAllDetallesHistoriaClinica() {
        return detalleHistoriaClinicaRepository.findAll();
    }

    public DetalleHistoriaClinica getDetalleHistoriaClinicaById(Long id) {
        return detalleHistoriaClinicaRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el detalle de historia clínica con ID: " + id));
    }

    public DetalleHistoriaClinica saveDetalleHistoriaClinica(DetalleHistoriaClinica detalleHistoriaClinica) {
        Colaborador colaborador = colaboradorRepository.findById(detalleHistoriaClinica.getColaborador().getId())
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el colaborador con ID: " + detalleHistoriaClinica.getColaborador().getId()));

        HistoriaClinica historiaClinica = historiaClinicaRepository.findById(detalleHistoriaClinica.getHistoriaClinica().getId())
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró la historia clínica con ID: " + detalleHistoriaClinica.getHistoriaClinica().getId()));

        detalleHistoriaClinica.setColaborador(colaborador);
        detalleHistoriaClinica.setHistoriaClinica(historiaClinica);

        return detalleHistoriaClinicaRepository.save(detalleHistoriaClinica);
    }

    public void deleteDetalleHistoriaClinica(Long id) {
        detalleHistoriaClinicaRepository.deleteById(id);
    }
}
