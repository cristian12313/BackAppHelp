package com.upc.backapphelp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoDonacionDTO {
    private Long idTipodonacion;
    private String nombre;
}
