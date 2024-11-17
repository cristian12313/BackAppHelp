package com.upc.backapphelp.entities;

import com.upc.backapphelp.security.entities.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false)
    private Long idUsuario;


    @Column( nullable = false, unique = true)
    private String username;


    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @Size(max = 25)
    @NotNull
    @Column(name = "apellidos", nullable = false, length = 25)
    private String apellidos;

    @Size(max = 50)
    @NotNull
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @Size(max = 8)
    @NotNull
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Size(max = 9)
    @Column(name = "telefono", length = 9)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_tipousuario")
    private Tipousuario tipousuario;

}