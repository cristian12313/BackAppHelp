package com.upc.backapphelp.dtos;

import com.upc.backapphelp.entities.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonacionDTO {
    private Long idDonacion;

    private String ubicacion;

    private BigDecimal monto;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private String detalle;

    private Campania campania;

    private Distrito distrito;

    private Estado estado;

    private Tipodonacion tipodonacion;

    private User user;
}
