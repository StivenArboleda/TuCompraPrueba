package com.tucompra.service;

import com.tucompra.helpers.ClinicaExcepcion;
import com.tucompra.model.Mascota;
import com.tucompra.model.Usuario;
import com.tucompra.repository.MascotaRepository;
import com.tucompra.repository.UsuarioRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    public Mascota getMascotaById(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró la mascota con ID: " + id));
    }

    public Mascota saveMascota(Mascota mascota) {
        Usuario usuario = usuarioRepository.findById(mascota.getUsuario().getId())
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el usuario con ID: " + mascota.getUsuario().getId()));
        mascota.setUsuario(usuario);
        return mascotaRepository.save(mascota);
    }

    public void deleteMascota(Long id) {
        mascotaRepository.deleteById(id);
    }
}
