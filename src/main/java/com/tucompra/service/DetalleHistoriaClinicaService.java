package com.tucompra.service;

import com.tucompra.helpers.ClinicaExcepcion;
import com.tucompra.model.*;
import com.tucompra.repository.ColaboradorRepository;
import com.tucompra.repository.DetalleHistoriaClinicaRepository;
import com.tucompra.repository.HistoriaClinicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetalleHistoriaClinicaService {

    @Autowired
    private DetalleHistoriaClinicaRepository detalleHistoriaClinicaRepository;

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<DetalleHistoriaClinica> getAllDetallesHistoriaClinica() {
        return detalleHistoriaClinicaRepository.findAll();
    }

    public DetalleHistoriaDTO getDetalleHistoriaClinica(Long id) {
        DetalleHistoriaClinica detalle = detalleHistoriaClinicaRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el detalle de historia clínica con ID: " + id));

        return convertirADetalleHistoriaClinicaDTO(detalle);
    }
    public DetalleHistoriaDTO convertirADetalleHistoriaClinicaDTO(DetalleHistoriaClinica detalleHistoriaClinica) {
        DetalleHistoriaDTO dto = new DetalleHistoriaDTO();
        dto.setId(detalleHistoriaClinica.getId());
        dto.setTemperatura(detalleHistoriaClinica.getTemperatura());
        dto.setPeso(detalleHistoriaClinica.getPeso());
        dto.setFrecuenciaCardiaca(detalleHistoriaClinica.getFrecuenciaCardiaca());
        dto.setFrecuenciaRespiratoria(detalleHistoriaClinica.getFrecuenciaRespiratoria());
        dto.setFechaHora(detalleHistoriaClinica.getFechaHora());
        dto.setAlimentacion(detalleHistoriaClinica.getAlimentacion());
        dto.setHabitad(detalleHistoriaClinica.getHabitad());
        dto.setObservacion(detalleHistoriaClinica.getObservacion());

        ColaboradorDTO colaboradorDTO = convertirAColaboradorDTO(detalleHistoriaClinica.getColaborador());
        dto.setColaboradorDTO(colaboradorDTO);

        HistoriaClinicaDTO historiaClinicaDTO = convertirAHistoriaClinicaDTO(detalleHistoriaClinica.getHistoriaClinica());
        dto.setHistoriaClinicaDTO(historiaClinicaDTO);

        return dto;
    }

    private ColaboradorDTO convertirAColaboradorDTO(Colaborador colaborador) {
        ColaboradorDTO dto = new ColaboradorDTO();
        dto.setId(colaborador.getId());
        dto.setNombre(colaborador.getNombre());
        dto.setApellido(colaborador.getApellido());
        dto.setCargo(colaborador.getCargo());
        dto.setEspecialidad(colaborador.getEspecialidad());
        dto.setTipoDocumento(colaborador.getTipoDocumento());
        dto.setDocumentoIdentificacion(colaborador.getDocumentoIdentificacion());
        return dto;
    }

    private HistoriaClinicaDTO convertirAHistoriaClinicaDTO(HistoriaClinica historiaClinica) {
        HistoriaClinicaDTO dto = new HistoriaClinicaDTO();
        dto.setId(historiaClinica.getId());

        MascotaDTO mascotaDTO = convertirAMascotaDTO(historiaClinica.getMascota());
        dto.setMascotaDTO(mascotaDTO);

        dto.setFechaCreacion(historiaClinica.getFechaCreacion());
        return dto;
    }
    public MascotaDTO convertirAMascotaDTO(Mascota mascota) {
        MascotaDTO dto = new MascotaDTO();
        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setRaza(mascota.getRaza());
        dto.setSexo(mascota.getSexo());

        UsuarioDTO usuarioDTO = convertirAUsuarioDTO(mascota.getUsuario());
        dto.setUsuarioDTO(usuarioDTO);

        return dto;
    }
    private UsuarioDTO convertirAUsuarioDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setTipoDocumento(usuario.getTipoDocumento());
        dto.setDocumentoIdentificacion(usuario.getDocumentoIdentificacion());
        dto.setEstado(usuario.getEstado());
        dto.setSexo(usuario.getSexo());
        return dto;
    }

    public DetalleHistoriaClinica getDetalleHistoriaClinicaById(Long id) {
        return detalleHistoriaClinicaRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el detalle de historia clínica con ID: " + id));
    }

    public DetalleHistoriaClinica saveDetalleHistoriaClinica(DetalleHistoriaClinica detalleHistoriaClinica) {
        Colaborador colaborador = colaboradorRepository.findById(detalleHistoriaClinica.getColaborador().getId())
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el colaborador con ID: " + detalleHistoriaClinica.getColaborador().getId()));

        HistoriaClinica historiaClinica = historiaClinicaRepository.findById(detalleHistoriaClinica.getHistoriaClinica().getId())
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró la historia clínica con ID: " + detalleHistoriaClinica.getHistoriaClinica().getId()));

        detalleHistoriaClinica.setColaborador(colaborador);
        detalleHistoriaClinica.setHistoriaClinica(historiaClinica);

        return detalleHistoriaClinicaRepository.save(detalleHistoriaClinica);
    }

    @Transactional
    public void deleteDetalleHistoriaClinica(Long id) {
        DetalleHistoriaClinica detalleHistoriaClinica = detalleHistoriaClinicaRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el detalle de historia clínica con ID: " + id));

        HistoriaClinica historiaClinica = historiaClinicaRepository.findById(detalleHistoriaClinica.getHistoriaClinica().getId())
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró la historia clínica con ID: " + detalleHistoriaClinica.getHistoriaClinica().getId()));


        historiaClinica.getDetallesHistoriaClinica().remove(detalleHistoriaClinica);
        detalleHistoriaClinicaRepository.deleteById(id);
    }
}
