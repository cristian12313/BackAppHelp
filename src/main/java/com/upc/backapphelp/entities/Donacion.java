package com.upc.backapphelp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "donacion")
public class Donacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDonacion", nullable = false)
    private Long idDonacion;

    @Size(max = 200)
    @NotNull
    @Column(name = "detalle", nullable = false, length = 200)
    private String detalle;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @NotNull
    @Column(name = "monto", nullable = false, precision = 7, scale = 2)
    private BigDecimal monto;

    @Size(max = 50)
    @NotNull
    @Column(name = "ubicacion", nullable = false, length = 50)
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "id_campania")
    private Campania campania;

    @ManyToOne
    @JoinColumn(name = "id_distrito")
    private Distrito distrito;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_tipodonacion")
    private Tipodonacion tipodonacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;

}