package com.upc.backapphelp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuentabancariaDTO {
    private Long idCuentaBanc;
    private String nombreBanco;
    private String numneroCuenta;
    private String cci;
}
