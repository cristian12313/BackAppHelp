package com.upc.backapphelp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstado", nullable = false)
    private Long idEstado;

    @Size(max = 25)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

}