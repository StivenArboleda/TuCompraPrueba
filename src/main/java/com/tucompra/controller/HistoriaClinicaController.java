package com.tucompra.controller;

import com.tucompra.model.HistoriaClinica;
import com.tucompra.model.HistoriaClinicaDTO;
import com.tucompra.service.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historias-clinicas")
@CrossOrigin(origins = "http://localhost:4200")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @GetMapping
    public List<HistoriaClinicaDTO> getAllHistoriasClinicas() {
        return historiaClinicaService.getAllHistoriasClinicas();
    }

    @GetMapping("/{id}")
    public HistoriaClinicaDTO getHistoriaClinicaById(@PathVariable Long id) {
        return historiaClinicaService.getHistoriaClinicaById(id);
    }

    @PostMapping
    public HistoriaClinica createHistoriaClinica(@RequestBody HistoriaClinica historiaClinica) {
        return historiaClinicaService.saveHistoriaClinica(historiaClinica);
    }

    @PutMapping("/{id}")
    public HistoriaClinica updateHistoriaClinica(@PathVariable Long id, @RequestBody HistoriaClinica historiaClinica) {
        historiaClinica.setId(id);
        return historiaClinicaService.saveHistoriaClinica(historiaClinica);
    }

    @DeleteMapping("/{id}")
    public void deleteHistoriaClinica(@PathVariable Long id) {
        historiaClinicaService.deleteHistoriaClinica(id);
    }
}
