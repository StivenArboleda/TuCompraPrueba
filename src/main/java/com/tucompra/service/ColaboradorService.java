package com.tucompra.service;

import com.tucompra.helpers.ClinicaExcepcion;
import com.tucompra.model.Colaborador;
import com.tucompra.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> getAllColaboradores() {
        return colaboradorRepository.findAll();
    }

    public Colaborador getColaboradorById(Long id) {
        return colaboradorRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el colaborador con ID: " + id));
    }

    public Colaborador saveColaborador(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public void deleteColaborador(Long id) {
        colaboradorRepository.deleteById(id);
    }
}
