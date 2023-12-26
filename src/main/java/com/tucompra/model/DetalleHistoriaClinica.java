package com.tucompra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "detalle_historia_clinica")
@Data
public class DetalleHistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Debe ingresar el valor de la temperatura")
    private Double temperatura;

    @Column(precision = 19, scale = 2)
    @NotNull(message = "Debe ingresar el valor del peso")
    private BigDecimal peso;

    @Column(name = "frecuencia_cardiaca", precision = 19, scale = 2)
    @NotNull(message = "Debe ingresar el valor de la frecuencia cardiaca")
    private BigDecimal frecuenciaCardiaca;

    @Column(name = "frecuencia_respiratoria", precision = 19, scale = 2)
    @NotNull(message = "Debe ingresar el valor de la frecuencia respitoria")
    private BigDecimal frecuenciaRespiratoria;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private Date fechaHora;

    @NotBlank(message = "Debe ingresar la alimentacion de la mascota")
    private String alimentacion;

    @NotBlank(message = "Debe ingresar el habitad de la mascota")
    private String habitad;

    @NotBlank(message = "Debe ingresar una observacion de la mascota")
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "historia_clinica_id")
    @JsonBackReference
    private HistoriaClinica historiaClinica;

}
