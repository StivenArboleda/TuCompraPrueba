package com.tucompra.controller;

import com.tucompra.model.Mascota;
import com.tucompra.service.MascotaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
@Api(tags = "Mascotas", description = "Operaciones relacionadas con mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    @ApiOperation("Obtener todas las mascotas")
    public List<Mascota> getAllMascotas() {
        return mascotaService.getAllMascotas();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtener una mascota por ID")
    public Mascota getMascotaById(@PathVariable Long id) {
        return mascotaService.getMascotaById(id);
    }

    @PostMapping
    @ApiOperation("Crear una nueva mascota")
    public Mascota createMascota(@RequestBody Mascota mascota) {
        return mascotaService.saveMascota(mascota);
    }

    @PutMapping("/{id}")
    @ApiOperation("Actualizar una mascota existente")
    public Mascota updateMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        //mascota.setId(id);
        return mascotaService.saveMascota(mascota);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar una mascota por ID")
    public void deleteMascota(@PathVariable Long id) {
        mascotaService.deleteMascota(id);
    }
}
