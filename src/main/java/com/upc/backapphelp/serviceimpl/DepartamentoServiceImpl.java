package com.upc.backapphelp.serviceimpl;

import com.upc.backapphelp.entities.Departamento;
import com.upc.backapphelp.repositories.DepartamentoRepositorio;
import com.upc.backapphelp.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;
    @Override
    public Departamento insetarDepartamento(Departamento departamento) {
        return departamentoRepositorio.save(departamento);
    }

    @Override
    public List<Departamento> listarDepartamento() {
        return departamentoRepositorio.findAll();
    }

    @Override
    public Departamento updateDepartamento(Departamento departamento) {
        if(departamentoRepositorio.existsById(departamento.getIdDepartamento())){
            return departamentoRepositorio.save(departamento);
        }
        return null;
    }

    @Override
    public void eliminar(long id) {
        if(departamentoRepositorio.findById(id).isPresent()){
            departamentoRepositorio.deleteById(id);
        }
    }
    @Override
    public Departamento buscarPorId(long id) {
        if(departamentoRepositorio.findById(id).isPresent()){
            return departamentoRepositorio.findById(id).get();
        }
        return null;
    }

}
