package com.tucompra.service;

import com.tucompra.helpers.ClinicaExcepcion;
import com.tucompra.model.Usuario;
import com.tucompra.repository.HistoriaClinicaRepository;
import com.tucompra.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) throws ClinicaExcepcion{
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el usuario con ID: " + id));
    }

    public Usuario saveUsuario(Usuario usuario) throws ClinicaExcepcion {

        if (usuarioRepository.existsByDocumentoIdentificacion(usuario.getDocumentoIdentificacion())) {
            throw new ClinicaExcepcion("Ya existe un usuario con la misma cédula: " + usuario.getDocumentoIdentificacion());
        }

        try {

            Usuario savedUsuario = usuarioRepository.save(usuario);

            if (usuario.getMascotas() != null) {
                usuario.getMascotas().forEach(mascota -> mascota.setUsuario(savedUsuario));
            }

            return savedUsuario;
        } catch (Exception e) {
            throw new ClinicaExcepcion("Error al guardar el usuario", e);
        }
    }

    public Usuario updateUsuario(Long id, Usuario usuario) throws ClinicaExcepcion {
        Usuario existingUsuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el usuario con ID: " + id));

        if (usuario.getDocumentoIdentificacion().equals(existingUsuario.getDocumentoIdentificacion())) {

            existingUsuario.setNombre(usuario.getNombre());
            existingUsuario.setApellido(usuario.getApellido());
            existingUsuario.setTipoDocumento(usuario.getTipoDocumento());
            existingUsuario.setDocumentoIdentificacion(usuario.getDocumentoIdentificacion());
            existingUsuario.setEstado(usuario.getEstado());
            existingUsuario.setSexo(usuario.getSexo());
            return usuarioRepository.save(existingUsuario);
        }
        else if(usuarioRepository.existsByDocumentoIdentificacion(usuario.getDocumentoIdentificacion())){
            throw new ClinicaExcepcion("Ya existe un usuario con la misma cédula: " + usuario.getDocumentoIdentificacion());
        }
        return existingUsuario;
    }

    @Transactional
    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ClinicaExcepcion("No se encontró el usuario con ID: " + id));

        historiaClinicaRepository.deleteByMascotaUsuarioId(id);

        usuarioRepository.deleteById(id);
    }

}
