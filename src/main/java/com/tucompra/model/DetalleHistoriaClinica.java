package com.tucompra.model;

import jakarta.persistence.*;
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

    private Double temperatura;

    @Column(precision = 19, scale = 2)
    private BigDecimal peso;

    @Column(name = "frecuencia_cardiaca", precision = 19, scale = 2)
    private BigDecimal frecuenciaCardiaca;

    @Column(name = "frecuencia_respiratoria", precision = 19, scale = 2)
    private BigDecimal frecuenciaRespiratoria;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private Date fechaHora;

    private String alimentacion;
    private String habitad;
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "historia_clinica_id")
    private HistoriaClinica historiaClinica;

}
