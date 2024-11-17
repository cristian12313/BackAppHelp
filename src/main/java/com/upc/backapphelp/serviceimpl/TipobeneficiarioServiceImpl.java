package com.upc.backapphelp.serviceimpl;

import com.upc.backapphelp.entities.Tipobeneficiario;
import com.upc.backapphelp.repositories.TipobeneficiarioRepositorio;
import com.upc.backapphelp.services.TipobeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipobeneficiarioServiceImpl implements TipobeneficiarioService {
    @Autowired
    private TipobeneficiarioRepositorio tipobeneficiarioRepositorio;
    @Override
    public Tipobeneficiario insertarTipobeneficiario(Tipobeneficiario tipobeneficiario) {
        return tipobeneficiarioRepositorio.save(tipobeneficiario);
    }

    @Override
    public List<Tipobeneficiario> listarTipobeneficiario() {
        return tipobeneficiarioRepositorio.findAll();
    }

    @Override
    public Tipobeneficiario updateTipobeneficiario(Tipobeneficiario tipobeneficiario) {
        if(tipobeneficiarioRepositorio.existsById(tipobeneficiario.getIdTipobene())){
            return tipobeneficiarioRepositorio.save(tipobeneficiario);
        }
        return null;
    }
    @Override
    public void eliminar(long id) {
        if(tipobeneficiarioRepositorio.findById(id).isPresent()){
            tipobeneficiarioRepositorio.deleteById(id);
        }
    }
    @Override
    public Tipobeneficiario buscarPorId(long id) {
        if(tipobeneficiarioRepositorio.findById(id).isPresent()){
            return tipobeneficiarioRepositorio.findById(id).get();
        }
        return null;
    }
}
