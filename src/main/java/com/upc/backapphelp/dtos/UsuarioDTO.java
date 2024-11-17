package com.upc.backapphelp.dtos;

import com.upc.backapphelp.entities.Tipousuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long idUsuario;
    private String username;
    private String password;
    private String apellidos;
    private String correo;
    private String dni;
    private String telefono;
    private Tipousuario tipousuario;
}
