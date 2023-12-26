package com.tucompra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleHistoriaDTO {


    private Long id;
    private Double temperatura;
    private BigDecimal peso;
    private BigDecimal frecuenciaCardiaca;
    private BigDecimal frecuenciaRespiratoria;
    private Date fechaHora;
    private String alimentacion;
    private String habitad;
    private String observacion;

    @JsonProperty("colaborador")
    private ColaboradorDTO colaboradorDTO;

    @JsonProperty("historiaClinica")
    private HistoriaClinicaDTO historiaClinicaDTO;

}
