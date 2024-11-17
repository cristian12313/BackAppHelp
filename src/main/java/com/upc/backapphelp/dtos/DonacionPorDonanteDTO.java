package com.upc.backapphelp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonacionPorDonanteDTO {
    private String nombreCampania;
    private String nombreTipoDonacion;
    private String nombreDistrito;
    private String nombreEstado;
}
