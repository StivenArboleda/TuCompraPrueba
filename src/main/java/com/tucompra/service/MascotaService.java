package com.tucompra.service;

import com.tucompra.helpers.ClinicaExcepcion;
import com.tucompra.model.Mascota;
import com.tucompra.model.MascotaDTO;
import com.tucompra.model.Usuario;
import com.tucompra.model.UsuarioDTO;
import com.tucompra.repository.HistoriaClinicaRepository;
import com.tucompra.repository.MascotaRepository;
import com.tucompra.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    public List<MascotaDTO> getAllMascotas() {
        List<Mascota> mascotas = mascotaRepository.findAll();
        return mascotas.stream()
                .map(mascota -> {
                    MascotaDTO dto = new MascotaDTO();
                    UsuarioDTO usuarioDTO = new UsuarioDTO();
                    dto.setId(mascota.getId());
                    dto.setNombre(mascota.getNombre());
                    dto.setRaza(mascota.getRaza());
                    dto.setSexo(mascota.getSexo());

                    usuarioDTO.setId((mascota.getUsuario().getId()));
                    usuarioDTO.setNombre(mascota.getUsuario().getNombre());
                    usuarioDTO.setApellido(mascota.getUsuario().getApellido());
                    usuarioDTO.setTipoDocumento(mascota.getUsuario().getTipoDocumento());
                    usuarioDTO.setDocumentoIdentificacion(mascota.getUsuario().getDocumentoIdentificacion());
                    usuarioDTO.setEstado(mascota.getUsuario().getEstado());
                    usuarioDTO.setSexo(mascota.getUsuario().getSexo());

                    dto.setUsuarioDTO(usuarioDTO);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public MascotaDTO getMascotaById(Long id) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró la mascota con ID: " + id));

        MascotaDTO dto = new MascotaDTO();
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setRaza(mascota.getRaza());
        dto.setSexo(mascota.getSexo());

        usuarioDTO.setId((mascota.getUsuario().getId()));
        usuarioDTO.setNombre(mascota.getUsuario().getNombre());
        usuarioDTO.setApellido(mascota.getUsuario().getApellido());
        usuarioDTO.setTipoDocumento(mascota.getUsuario().getTipoDocumento());
        usuarioDTO.setDocumentoIdentificacion(mascota.getUsuario().getDocumentoIdentificacion());
        usuarioDTO.setEstado(mascota.getUsuario().getEstado());
        usuarioDTO.setSexo(mascota.getUsuario().getSexo());

        dto.setUsuarioDTO(usuarioDTO);
        return dto;
    }

    public Mascota saveMascota(Mascota mascota) {
        Usuario usuario = usuarioRepository.findById(mascota.getUsuario().getId())
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el usuario con ID: " + mascota.getUsuario().getId()));
        mascota.setUsuario(usuario);
        return mascotaRepository.save(mascota);
    }

    @Transactional
    public void deleteMascota(Long id) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró la mascota con ID: " + id));

        Usuario usuario = usuarioRepository.findById(mascota.getUsuario().getId())
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el usuario con ID: " + mascota.getUsuario().getId()));

        if (historiaClinicaRepository.existsByMascotaId(id)) {
            historiaClinicaRepository.deleteByMascotaId(mascota.getId());
        }
        usuario.getMascotas().remove(mascota);
        mascotaRepository.deleteById(id);
    }
}
