package com.tucompra.controller;

import com.tucompra.model.Mascota;
import com.tucompra.model.MascotaDTO;
import com.tucompra.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public List<MascotaDTO>getAllMascotas() {
        return mascotaService.getAllMascotas();
    }

    @GetMapping("/{id}")
    public MascotaDTO getMascotaById(@PathVariable Long id) {
        return mascotaService.getMascotaById(id);
    }

    @PostMapping
    public Mascota createMascota(@RequestBody Mascota mascota) {
        return mascotaService.saveMascota(mascota);
    }

    @PutMapping("/{id}")
    public Mascota updateMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        mascota.setId(id);
        return mascotaService.saveMascota(mascota);
    }

    @DeleteMapping("/{id}")
    public void deleteMascota(@PathVariable Long id) {
        mascotaService.deleteMascota(id);
    }
}
