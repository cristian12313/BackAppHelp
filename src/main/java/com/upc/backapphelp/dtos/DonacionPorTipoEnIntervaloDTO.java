package com.upc.backapphelp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonacionPorTipoEnIntervaloDTO {
    private String nombreCampania;
    private String nombreEstado;
    private LocalDate fechaInicio;
}
