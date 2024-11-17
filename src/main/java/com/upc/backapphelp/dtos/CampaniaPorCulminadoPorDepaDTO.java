package com.upc.backapphelp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampaniaPorCulminadoPorDepaDTO {
    private String nombreCampania;
    private String nombreDepartamento;
    private String dniDamnificado;
    private String nombreTipoDonacion;
    private String nombreTipoBeneficiario;
}
