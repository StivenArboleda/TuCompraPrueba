package com.tucompra;

import com.tucompra.model.Mascota;
import com.tucompra.model.Usuario;
import com.tucompra.repository.MascotaRepository;
import com.tucompra.repository.UsuarioRepository;
import com.tucompra.service.MascotaService;
import com.tucompra.service.UsuarioService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MascotaServiceTest {

    @Mock
    private MascotaRepository mascotaRepository;

    @InjectMocks
    private MascotaService mascotaService;

    private static Usuario usuario;
    private static Mascota mascota;

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

        mascota = new Mascota();
        mascota.setId(1L);
        mascota.setNombre("Zeus");
        mascota.setRaza("Golden");
        mascota.setSexo("Macho");
        mascota.setUsuario(usuario);
    }

    @Test
    public void whenSendInvalidNameUser_Expected_CodeResponse404() {

        Long idMascota = 1L;
        when(mascotaRepository.findById(idMascota)).thenReturn(Optional.of(mascota));

        Mascota resultado = mascotaService.getMascotaById(idMascota);

        assertEquals(idMascota, resultado.getId());
        assertEquals(mascota.getNombre(), resultado.getNombre());
        assertEquals(usuario.getDocumentoIdentificacion(), resultado.getUsuario().getDocumentoIdentificacion());
    }



}
