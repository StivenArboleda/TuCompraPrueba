package com.tucompra.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mascota")
@Data
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String raza;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String sexo;

}
