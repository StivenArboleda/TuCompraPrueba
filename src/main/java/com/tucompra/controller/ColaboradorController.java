package com.tucompra.controller;

import com.tucompra.model.Colaborador;
import com.tucompra.service.ColaboradorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
@Api(tags = "Colaboradores", description = "Operaciones relacionadas con colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    @ApiOperation("Obtener todos los colaboradores")
    public List<Colaborador> getAllColaboradores() {
        return colaboradorService.getAllColaboradores();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtener un colaborador por ID")
    public Colaborador getColaboradorById(@PathVariable Long id) {
        return colaboradorService.getColaboradorById(id);
    }

    @PostMapping
    @ApiOperation("Crear un nuevo colaborador")
    public Colaborador createColaborador(@RequestBody Colaborador colaborador) {
        return colaboradorService.saveColaborador(colaborador);
    }

    @PutMapping("/{id}")
    @ApiOperation("Actualizar un colaborador existente")
    public Colaborador updateColaborador(@PathVariable Long id, @RequestBody Colaborador colaborador) {
        //colaborador.setId(id);
        return colaboradorService.saveColaborador(colaborador);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar un colaborador por ID")
    public void deleteColaborador(@PathVariable Long id) {
        colaboradorService.deleteColaborador(id);
    }
}
