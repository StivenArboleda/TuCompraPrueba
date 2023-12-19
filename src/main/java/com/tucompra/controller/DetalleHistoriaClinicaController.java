package com.tucompra.controller;

import com.tucompra.model.DetalleHistoriaClinica;
import com.tucompra.service.DetalleHistoriaClinicaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles-historias-clinicas")
@Api(tags = "Detalles de Historias Clínicas", description = "Operaciones relacionadas con detalles de historias clínicas")
public class DetalleHistoriaClinicaController {

    @Autowired
    private DetalleHistoriaClinicaService detalleHistoriaClinicaService;

    @GetMapping
    @ApiOperation("Obtener todos los detalles de historias clínicas")
    public List<DetalleHistoriaClinica> getAllDetallesHistoriaClinica() {
        return detalleHistoriaClinicaService.getAllDetallesHistoriaClinica();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtener un detalle de historia clínica por ID")
    public DetalleHistoriaClinica getDetalleHistoriaClinicaById(@PathVariable Long id) {
        return detalleHistoriaClinicaService.getDetalleHistoriaClinicaById(id);
    }

    @PostMapping
    @ApiOperation("Crear un nuevo detalle de historia clínica")
    public DetalleHistoriaClinica createDetalleHistoriaClinica(@RequestBody DetalleHistoriaClinica detalleHistoriaClinica) {
        return detalleHistoriaClinicaService.saveDetalleHistoriaClinica(detalleHistoriaClinica);
    }

    @PutMapping("/{id}")
    @ApiOperation("Actualizar un detalle de historia clínica existente")
    public DetalleHistoriaClinica updateDetalleHistoriaClinica(@PathVariable Long id, @RequestBody DetalleHistoriaClinica detalleHistoriaClinica) {
        //detalleHistoriaClinica.setId(id);
        return detalleHistoriaClinicaService.saveDetalleHistoriaClinica(detalleHistoriaClinica);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar un detalle de historia clínica por ID")
    public void deleteDetalleHistoriaClinica(@PathVariable Long id) {
        detalleHistoriaClinicaService.deleteDetalleHistoriaClinica(id);
    }
}
