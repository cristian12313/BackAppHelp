package com.upc.backapphelp.serviceimpl;

import com.upc.backapphelp.entities.Estado;
import com.upc.backapphelp.repositories.EstadoRepository;
import com.upc.backapphelp.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public Estado insertEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public List<Estado> listEstado() {
        return estadoRepository.findAll();
    }

    @Override
    public Estado updateEstado(Estado estado) {
        if (estadoRepository.existsById(estado.getIdEstado())) {
            return estadoRepository.save(estado);
        }
        return null;
    }
    @Override
    public void eliminar(long id) {
        if(estadoRepository.findById(id).isPresent()){
            estadoRepository.deleteById(id);
        }
    }
    @Override
    public Estado buscarPorId(long id) {
        if(estadoRepository.findById(id).isPresent()){
            return estadoRepository.findById(id).get();
        }
        return null;
    }
}
