package com.upc.backapphelp.serviceimpl;

import com.upc.backapphelp.entities.Tipousuario;
import com.upc.backapphelp.repositories.TipousuarioRepositorio;
import com.upc.backapphelp.services.TipousuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipousuarioServiceImpl implements TipousuarioService {
    @Autowired
    private TipousuarioRepositorio tipousuarioRepositorio;
    @Override
    public Tipousuario insetarTipousuario(Tipousuario tipousuario) {
        return tipousuarioRepositorio.save(tipousuario);
    }

    @Override
    public List<Tipousuario> listarTipousuario() {
        return tipousuarioRepositorio.findAll();
    }

    @Override
    public Tipousuario updateTipousuario(Tipousuario tipousuario) {
        if(tipousuarioRepositorio.existsById(tipousuario.getIdTipousuario())){
            return tipousuarioRepositorio.save(tipousuario);
        }
        return null;
    }
    @Override
    public void eliminar(long id) {
        if(tipousuarioRepositorio.findById(id).isPresent()){
            tipousuarioRepositorio.deleteById(id);
        }
    }
    @Override
    public Tipousuario buscarPorId(long id) {
        if(tipousuarioRepositorio.findById(id).isPresent()){
            return tipousuarioRepositorio.findById(id).get();
        }
        return null;
    }
}
