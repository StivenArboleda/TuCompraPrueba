package com.tucompra.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "mascota")
@Data
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar el nombre de la mascota")
    private String nombre;

    @NotBlank(message = "Debe ingresar la raza de la mascota")
    private String raza;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;

    @NotBlank(message = "Debe ingresar el sexo de la mascota")
    private String sexo;

}
