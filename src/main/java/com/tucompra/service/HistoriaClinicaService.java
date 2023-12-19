package com.tucompra.service;

import com.tucompra.helpers.ClinicaExcepcion;
import com.tucompra.model.HistoriaClinica;
import com.tucompra.repository.HistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    public List<HistoriaClinica> getAllHistoriasClinicas() {
        return historiaClinicaRepository.findAll();
    }

    public HistoriaClinica getHistoriaClinicaById(Long id) {
        return historiaClinicaRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró la historia clínica con ID: " + id));
    }

    public HistoriaClinica saveHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    public void deleteHistoriaClinica(Long id) {
        historiaClinicaRepository.deleteById(id);
    }
}
