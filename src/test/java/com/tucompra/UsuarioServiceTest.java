package com.tucompra;

import static org.junit.jupiter.api.Assertions.*;

import com.tucompra.helpers.ClinicaExcepcion;
import com.tucompra.model.Mascota;
import com.tucompra.model.Usuario;
import com.tucompra.repository.UsuarioRepository;
import com.tucompra.service.UsuarioService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private static Usuario usuario;


    @BeforeAll
    static void setUp() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Stiven Test");
        usuario.setApellido("Arboleda Test");
        usuario.setTipoDocumento("CC");
        usuario.setDocumentoIdentificacion("1111111111");
        usuario.setEstado("Activo");
        usuario.setSexo("Masculino");
    }

    @Test
    public void whenSendValidUser_expected_addElement() {

        Long idUsuario = 1L;
        when(usuarioRepository.findById(idUsuario)).thenReturn(Optional.of(usuario));

        Usuario resultado = usuarioService.getUsuarioById(idUsuario);

        assertEquals(idUsuario, resultado.getId());
        assertEquals(usuario.getDocumentoIdentificacion(), resultado.getDocumentoIdentificacion());
    }

}
