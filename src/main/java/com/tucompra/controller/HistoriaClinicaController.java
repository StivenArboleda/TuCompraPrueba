package com.tucompra.controller;

import com.tucompra.model.HistoriaClinica;
import com.tucompra.service.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historias-clinicas")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @GetMapping
    public List<HistoriaClinica> getAllHistoriasClinicas() {
        return historiaClinicaService.getAllHistoriasClinicas();
    }

    @GetMapping("/{id}")
    public HistoriaClinica getHistoriaClinicaById(@PathVariable Long id) {
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
