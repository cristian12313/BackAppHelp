package com.upc.backapphelp.dtos;

import com.upc.backapphelp.entities.Departamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistritoDTO {
    private Long idDistrito;

    private String nombre;

    private Departamento departamento;
}
