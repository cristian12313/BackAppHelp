package com.upc.backapphelp.controllers;

import com.upc.backapphelp.dtos.UsuarioDTO;
import com.upc.backapphelp.entities.User;
import com.upc.backapphelp.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "${ip.frontend}")
@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder bcrypt;

    @PostMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public void createUser(@RequestBody User user) {
        String bcryptPassword = bcrypt.encode(user.getPassword());
        user.setPassword(bcryptPassword);
        usuarioService.save(user);
    }

    @PostMapping("/save/{user_id}/{rol_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Integer> saveUseRol(@PathVariable("user_id") Long user_id,
                                              @PathVariable("rol_id") Long rol_id){
        return new ResponseEntity<Integer>(usuarioService.insertUserRol(user_id, rol_id), HttpStatus.OK);
        //return new ResponseEntity<Integer>(uService.insertUserRol2(user_id, rol_id),HttpStatus.OK);
    }
    //

    @GetMapping("/usuarios")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE','ADMIN')")
    public List<UsuarioDTO> listUsuarios() {
        List<User> list = usuarioService.listUsuario();
        ModelMapper modelMapper = new ModelMapper();
        List<UsuarioDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }
    @PostMapping("/usuario")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE','ADMIN')")
    public UsuarioDTO insertUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User usuario = modelMapper.map(usuarioDTO, User.class);
        usuario = usuarioService.insertUsuario(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
    @PutMapping("/usuario")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE','ADMIN')")
    public UsuarioDTO updateUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User usuario = modelMapper.map(usuarioDTO, User.class);
        usuario = usuarioService.updateUsuario(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
    @DeleteMapping("/usuario/{id}")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE','ADMIN')")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminar(id);
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioDTO> buscaUsuario(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        User user = usuarioService.buscarPorId(id);
        UsuarioDTO usuarioDTO = modelMapper.map(user, UsuarioDTO.class);
        return ResponseEntity.ok(usuarioDTO);
    }
}
