package com.tucompra.service;

import com.tucompra.helpers.ClinicaExcepcion;
import com.tucompra.model.*;
import com.tucompra.repository.HistoriaClinicaRepository;
import com.tucompra.repository.MascotaRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    private MascotaRepository mascotaRepository;


    public List<HistoriaClinicaDTO> getAllHistoriasClinicas() {
        List<HistoriaClinica> historias = historiaClinicaRepository.findAll();

        return historias.stream()
                .map(historia -> {
                    HistoriaClinicaDTO dto = new HistoriaClinicaDTO();
                    MascotaDTO mascotaDTO = new MascotaDTO();

                    dto.setId(historia.getId());
                    dto.setFechaCreacion(historia.getFechaCreacion());

                    if (historia.getMascota() != null) {
                        mascotaDTO.setId(historia.getMascota().getId());
                        mascotaDTO.setNombre(historia.getMascota().getNombre());
                        mascotaDTO.setRaza(historia.getMascota().getRaza());
                        mascotaDTO.setSexo(historia.getMascota().getSexo());

                        if (historia.getMascota().getUsuario() != null) {
                            UsuarioDTO usuarioDTO = new UsuarioDTO();
                            usuarioDTO.setId(historia.getMascota().getUsuario().getId());
                            usuarioDTO.setNombre(historia.getMascota().getUsuario().getNombre());
                            usuarioDTO.setApellido(historia.getMascota().getUsuario().getApellido());
                            usuarioDTO.setTipoDocumento(historia.getMascota().getUsuario().getTipoDocumento());
                            usuarioDTO.setDocumentoIdentificacion(historia.getMascota().getUsuario().getDocumentoIdentificacion());
                            usuarioDTO.setEstado(historia.getMascota().getUsuario().getEstado());
                            usuarioDTO.setSexo(historia.getMascota().getUsuario().getSexo());

                            mascotaDTO.setUsuarioDTO(usuarioDTO);
                        }
                    }

                    dto.setMascotaDTO(mascotaDTO);
                    return dto;
                })
                .collect(Collectors.toList());
    }




    public HistoriaClinicaDTO getHistoriaClinicaById(Long id) {
        HistoriaClinica historia = historiaClinicaRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró la historia clínica con ID: " + id));

        HistoriaClinicaDTO dto = new HistoriaClinicaDTO();
        MascotaDTO mascotaDTO = new MascotaDTO();

        dto.setId(historia.getId());
        dto.setFechaCreacion(historia.getFechaCreacion());

        if (historia.getMascota() != null) {
            mascotaDTO.setId(historia.getMascota().getId());
            mascotaDTO.setNombre(historia.getMascota().getNombre());
            mascotaDTO.setRaza(historia.getMascota().getRaza());
            mascotaDTO.setSexo(historia.getMascota().getSexo());

            if (historia.getMascota().getUsuario() != null) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setId(historia.getMascota().getUsuario().getId());
                usuarioDTO.setNombre(historia.getMascota().getUsuario().getNombre());
                usuarioDTO.setApellido(historia.getMascota().getUsuario().getApellido());
                usuarioDTO.setTipoDocumento(historia.getMascota().getUsuario().getTipoDocumento());
                usuarioDTO.setDocumentoIdentificacion(historia.getMascota().getUsuario().getDocumentoIdentificacion());
                usuarioDTO.setEstado(historia.getMascota().getUsuario().getEstado());
                usuarioDTO.setSexo(historia.getMascota().getUsuario().getSexo());

                mascotaDTO.setUsuarioDTO(usuarioDTO);
            }
        }
        dto.setMascotaDTO(mascotaDTO);
        return dto;
    }

    public HistoriaClinica saveHistoriaClinica(HistoriaClinica historiaClinica) throws ClinicaExcepcion {
        Mascota mascota = mascotaRepository.findById(historiaClinica.getMascota().getId())
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró la mascota con ID: " + historiaClinica.getMascota().getId()));

        if (historiaClinicaRepository.existsByMascotaId(mascota.getId())) {
            throw new ClinicaExcepcion("La mascota ya tiene una historia clínica creada.");
        }

        historiaClinica.setMascota(mascota);
        return historiaClinicaRepository.save(historiaClinica);
    }

    public void deleteHistoriaClinica(Long id) {
        historiaClinicaRepository.deleteById(id);
    }
}
