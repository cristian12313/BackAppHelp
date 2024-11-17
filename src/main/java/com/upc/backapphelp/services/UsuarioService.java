package com.upc.backapphelp.services;

import com.upc.backapphelp.entities.User;

import java.util.List;

public interface UsuarioService {
    public void save(User user);
    public Integer insertUserRol(Long userId, Long rolId);
    public User insertUsuario(User usuario);
    public List<User> listUsuario();
    public User updateUsuario(User usuario);
    public void eliminar(long id);
    public User buscarPorId(long id);
}
