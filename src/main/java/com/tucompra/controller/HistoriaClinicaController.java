package com.tucompra.controller;

import com.tucompra.model.HistoriaClinica;
import com.tucompra.service.HistoriaClinicaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historias-clinicas")
@Api(tags = "Historias Clínicas", description = "Operaciones relacionadas con historias clínicas")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @GetMapping
    @ApiOperation("Obtener todas las historias clínicas")
    public List<HistoriaClinica> getAllHistoriasClinicas() {
        return historiaClinicaService.getAllHistoriasClinicas();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtener una historia clínica por ID")
    public HistoriaClinica getHistoriaClinicaById(@PathVariable Long id) {
        return historiaClinicaService.getHistoriaClinicaById(id);
    }

    @PostMapping
    @ApiOperation("Crear una nueva historia clínica")
    public HistoriaClinica createHistoriaClinica(@RequestBody HistoriaClinica historiaClinica) {
        return historiaClinicaService.saveHistoriaClinica(historiaClinica);
    }

    @PutMapping("/{id}")
    @ApiOperation("Actualizar una historia clínica existente")
    public HistoriaClinica updateHistoriaClinica(@PathVariable Long id, @RequestBody HistoriaClinica historiaClinica) {
        //historiaClinica.setId(id);
        return historiaClinicaService.saveHistoriaClinica(historiaClinica);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar una historia clínica por ID")
    public void deleteHistoriaClinica(@PathVariable Long id) {
        historiaClinicaService.deleteHistoriaClinica(id);
    }
}
