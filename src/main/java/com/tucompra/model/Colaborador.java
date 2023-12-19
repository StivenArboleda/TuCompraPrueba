package com.tucompra.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "colaborador")
@Data
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

}
