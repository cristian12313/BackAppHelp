package com.upc.backapphelp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "campania")
public class Campania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCampania", nullable = false)//ID
    private Long idCampania;

    @NotNull
    @Column(name = "culminado", nullable = false)
    private Boolean culminado = false;

    @Size(max = 200)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 50)
    @NotNull
    @Column(name = "ubicacion", nullable = false, length = 50)
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "id_cuentabancaria")
    private Cuentabancaria cuentabancaria;

    @ManyToOne
    @JoinColumn(name = "id_distrito")
    private Distrito distrito;

    @ManyToOne
    @JoinColumn(name = "id_tipobeneficia")
    private Tipobeneficiario tipobeneficiario;

    @ManyToOne
    @JoinColumn(name = "id_tipodonacion")
    private Tipodonacion tipodonacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;

}