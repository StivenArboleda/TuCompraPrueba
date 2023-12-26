package com.tucompra.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar el nombre del usuario")
    @Size(message = "El nombre debe ser entre 3 y 10 caracteres", min = 3, max = 10)
    private String nombre;

    @NotBlank(message = "Debe ingresar el apellido del usuario")
    @Size(message = "El apellido debe ser entre 3 y 10 caracteres", min = 3, max = 10)
    private String apellido;

    @NotBlank(message = "Debe ingresar el tipo de documento del usuario")
    @Size(message = "El tipo de documento debe ser entre 2 y 10 caracteres", min = 3, max = 10)
    private String tipoDocumento;

    @NotBlank(message = "Debe ingresar el documento de identificacion del usuario")
    @Size(message = "El documento de identificacion debe ser entre 6 y 14 caracteres", min = 3, max = 10)
    private String documentoIdentificacion;

    @NotBlank(message = "Debe ingresar el estado del usuario")
    private String estado;

    @NotBlank(message = "Debe ingresar el sexo del usuario")
    private String sexo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Mascota> mascotas = new ArrayList<>();

}
