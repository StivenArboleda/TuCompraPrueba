package com.tucompra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoriaClinicaDTO {
    private Long id;

    @JsonProperty("mascota")
    private MascotaDTO mascotaDTO;

    private Date fechaCreacion;
}
