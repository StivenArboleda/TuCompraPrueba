package com.tucompra.service;

import com.tucompra.helpers.ClinicaExcepcion;
import com.tucompra.model.HistoriaClinica;
import com.tucompra.model.Mascota;
import com.tucompra.repository.HistoriaClinicaRepository;
import com.tucompra.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<HistoriaClinica> getAllHistoriasClinicas() {
        return historiaClinicaRepository.findAll();
    }

    public HistoriaClinica getHistoriaClinicaById(Long id) {
        return historiaClinicaRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró la historia clínica con ID: " + id));
    }

    public HistoriaClinica saveHistoriaClinica(HistoriaClinica historiaClinica) {
        Mascota mascota =  mascotaRepository.findById(historiaClinica.getMascota().getId())
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró la mascota con ID: " + historiaClinica.getMascota().getId()));
        historiaClinica.setMascota(mascota);
        return historiaClinicaRepository.save(historiaClinica);
    }

    public void deleteHistoriaClinica(Long id) {
        historiaClinicaRepository.deleteById(id);
    }
}
