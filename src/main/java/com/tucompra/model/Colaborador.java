package com.tucompra.model;

import jakarta.persistence.*;

@Entity
@Table(name = "colaborador")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String cargo;
    private String especialidad;
    private String tipoDocumento;
    private String documentoIdentificacion;

    // Getters y setters

}
