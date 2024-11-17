package com.upc.backapphelp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cuentabancaria")
public class Cuentabancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCuentaBanc", nullable = false)
    private Long idCuentaBanc;

    @Size(max = 25)
    @NotNull
    @Column(name = "cci", nullable = false, length = 25)
    private String cci;

    @Size(max = 25)
    @NotNull
    @Column(name = "nombre_banco", nullable = false, length = 25)
    private String nombreBanco;

    @Size(max = 25)
    @NotNull
    @Column(name = "numnero_cuenta", nullable = false, length = 25)
    private String numneroCuenta;

}