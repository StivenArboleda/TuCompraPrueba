package com.tucompra.controller;

import com.tucompra.model.Usuario;
import com.tucompra.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "Usuarios", description = "Operaciones relacionadas con usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @ApiOperation("Obtener todos los usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtener un usuario por ID")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    @ApiOperation("Crear un nuevo usuario")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/{id}")
    @ApiOperation("Actualizar un usuario existente")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        //usuario.setId(id);
        return usuarioService.saveUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar un usuario por ID")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}

