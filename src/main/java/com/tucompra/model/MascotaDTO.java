package com.tucompra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotaDTO {

    private Long id;
    private String nombre;
    private String raza;
    private String sexo;

    @JsonProperty("usuario")
    private UsuarioDTO usuarioDTO;

}
