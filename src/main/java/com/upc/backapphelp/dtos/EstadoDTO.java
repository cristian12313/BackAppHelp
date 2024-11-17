package com.upc.backapphelp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoDTO {
    private Long idEstado;
    private String nombre;
//    private List<Donacion> donaciones = new ArrayList<>();
}
