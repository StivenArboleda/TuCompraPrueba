package com.tucompra.controller;

import com.tucompra.model.Colaborador;
import com.tucompra.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
@CrossOrigin(origins = "http://localhost:4200")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public List<Colaborador> getAllColaboradores() {
        return colaboradorService.getAllColaboradores();
    }

    @GetMapping("/{id}")
    public Colaborador getColaboradorById(@PathVariable Long id) {
        return colaboradorService.getColaboradorById(id);
    }

    @PostMapping
    public Colaborador createColaborador(@RequestBody Colaborador colaborador) {
        return colaboradorService.saveColaborador(colaborador);
    }

    @PutMapping("/{id}")
    public Colaborador updateColaborador(@PathVariable Long id, @RequestBody Colaborador colaborador) {
        colaborador.setId(id);
        return colaboradorService.saveColaborador(colaborador);
    }

    @DeleteMapping("/{id}")
    public void deleteColaborador(@PathVariable Long id) {
        colaboradorService.deleteColaborador(id);
    }
}
