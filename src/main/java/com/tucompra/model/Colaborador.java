package com.tucompra.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "colaborador")
@Data
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar el nombre del colaborador")
    @Size(message = "El nombre debe ser entre 3 y 20 caracteres", min = 3, max = 20)
    private String nombre;

    @NotBlank(message = "Debe ingresar el apellido del colaborador")
    @Size(message = "El apellido debe ser entre 3 y 20 caracteres", min = 3, max = 20)
    private String apellido;

    @NotBlank(message = "Debe ingresar el cargo del colaborador")
    @Size(message = "El cargo debe ser entre 3 y 20 caracteres", min = 3, max = 20)
    private String cargo;

    @NotBlank(message = "Debe ingresar el especialidad del colaborador")
    @Size(message = "El especialidad debe ser entre 3 y 20 caracteres", min = 3, max = 20)
    private String especialidad;

    @NotBlank(message = "Debe ingresar el tipo de documento del colaborador")
    @Size(message = "El tipo de documento debe ser entre 2 y 10 caracteres", min = 3, max = 10)
    private String tipoDocumento;

    @NotBlank(message = "Debe ingresar el documento de identificacion del colaborador")
    @Size(message = "El documento de identificacion debe ser entre 6 y 14 caracteres", min = 3, max = 10)
    private String documentoIdentificacion;

}
