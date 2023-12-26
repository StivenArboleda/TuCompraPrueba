package com.tucompra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String cargo;
    private String especialidad;
    private String tipoDocumento;
    private String documentoIdentificacion;
}
