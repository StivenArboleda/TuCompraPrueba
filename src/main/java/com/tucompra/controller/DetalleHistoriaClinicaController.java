package com.tucompra.controller;

import com.tucompra.model.DetalleHistoriaClinica;
import com.tucompra.service.DetalleHistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles-historias-clinicas")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleHistoriaClinicaController {

    @Autowired
    private DetalleHistoriaClinicaService detalleHistoriaClinicaService;

    @GetMapping
    public List<DetalleHistoriaClinica> getAllDetallesHistoriaClinica() {
        return detalleHistoriaClinicaService.getAllDetallesHistoriaClinica();
    }

    @GetMapping("/{id}")
    public DetalleHistoriaClinica getDetalleHistoriaClinicaById(@PathVariable Long id) {
        return detalleHistoriaClinicaService.getDetalleHistoriaClinicaById(id);
    }

    @PostMapping
    public DetalleHistoriaClinica createDetalleHistoriaClinica(@RequestBody DetalleHistoriaClinica detalleHistoriaClinica) {
        return detalleHistoriaClinicaService.saveDetalleHistoriaClinica(detalleHistoriaClinica);
    }

    @PutMapping("/{id}")
    public DetalleHistoriaClinica updateDetalleHistoriaClinica(@PathVariable Long id, @RequestBody DetalleHistoriaClinica detalleHistoriaClinica) {
        detalleHistoriaClinica.setId(id);
        return detalleHistoriaClinicaService.saveDetalleHistoriaClinica(detalleHistoriaClinica);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleHistoriaClinica(@PathVariable Long id) {
        detalleHistoriaClinicaService.deleteDetalleHistoriaClinica(id);
    }
}
