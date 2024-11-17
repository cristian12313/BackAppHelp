package com.upc.backapphelp.serviceimpl;

import com.upc.backapphelp.entities.Distrito;
import com.upc.backapphelp.repositories.DistritoRepository;
import com.upc.backapphelp.services.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoServiceImpl implements DistritoService {
    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public Distrito insertDistrito(Distrito distrito){
        return distritoRepository.save(distrito);
    }

    @Override
    public List<Distrito> listDistrito() {
        return distritoRepository.findAll();
    }

    @Override
    public Distrito updateDistrito(Distrito distrito) {
        if(distritoRepository.existsById(distrito.getIdDistrito())){
            return distritoRepository.save(distrito);
        }
        return null;
    }

    @Override
    public void eliminar(long id) {
        if(distritoRepository.findById(id).isPresent()){
            distritoRepository.deleteById(id);
        }
    }
    @Override
    public Distrito buscarPorId(long id) {
        if(distritoRepository.findById(id).isPresent()){
            return distritoRepository.findById(id).get();
        }
        return null;
    }
}
