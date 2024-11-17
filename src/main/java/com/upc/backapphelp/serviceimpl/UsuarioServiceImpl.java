package com.upc.backapphelp.serviceimpl;

import com.upc.backapphelp.entities.User;
import com.upc.backapphelp.repositories.UsuarioRepository;
import com.upc.backapphelp.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Transactional
    public void save(User user) {
        usuarioRepository.save(user);
    }

    public Integer insertUserRol(Long user_id, Long rol_id) {
        Integer result = 0;
        usuarioRepository.insertUserRol(user_id, rol_id);
        return 1;
    }
    @Override
    public User insertUsuario(User usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<User> listUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public User updateUsuario(User usuario) {
        if(usuarioRepository.existsById(usuario.getIdUsuario())){
            return usuarioRepository.save(usuario);
        }
        return null;
    }
    @Override
    public void eliminar(long id) {
        if(usuarioRepository.findById(id).isPresent()){
            usuarioRepository.deleteById(id);
        }
    }
    @Override
    public User buscarPorId(long id) {
        if(usuarioRepository.findById(id).isPresent()){
            return usuarioRepository.findById(id).get();
        }
        return null;
    }
}
