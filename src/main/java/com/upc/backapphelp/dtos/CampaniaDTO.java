package com.upc.backapphelp.dtos;

import com.upc.backapphelp.entities.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampaniaDTO {
    private Long idCampania;
    private Boolean culminado;
    private String descripcion;
    private String nombre;
    private String ubicacion;

    private Cuentabancaria cuentabancaria;

    private Distrito distrito;

    private Tipobeneficiario tipobeneficiario;

    private Tipodonacion tipodonacion;

    private User user;
}
