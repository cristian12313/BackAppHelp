package com.upc.backapphelp.serviceimpl;

import com.upc.backapphelp.dtos.CampaniaPorCulminadoPorDepaDTO;
import com.upc.backapphelp.dtos.DepartamentoPorNumCampaniaDTO;
import com.upc.backapphelp.entities.Campania;
import com.upc.backapphelp.repositories.CampaniaRepositorio;
import com.upc.backapphelp.services.CampaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaniaServiceImpl implements CampaniaService {
    @Autowired
    private CampaniaRepositorio campaniaRepositorio;
    @Override
    public Campania insertarCampania(Campania campania) {
        return campaniaRepositorio.save(campania);
    }

    @Override
    public List<Campania> listarCampania() {
        return campaniaRepositorio.findAll();
    }

    @Override
    public Campania updateCampania(Campania campania) {
        if(campaniaRepositorio.findById(campania.getIdCampania()).isPresent()){
            return campaniaRepositorio.save(campania);
        }
        return null;
    }

    @Override
    public void eliminar(long id) {
        if(campaniaRepositorio.findById(id).isPresent()){
            campaniaRepositorio.deleteById(id);
        }
    }

    @Override
    public Campania buscarPorId(long id) {
        if(campaniaRepositorio.findById(id).isPresent()){
            return campaniaRepositorio.findById(id).get();
        }
        return null;
    }

    @Override
    public List<CampaniaPorCulminadoPorDepaDTO> campaniasPorCulminadoPorDepartamento(Boolean pCulminado) {
        return campaniaRepositorio.campaniasPorCulminadoPorDepartamento(pCulminado);
    }

    @Override
    public List<DepartamentoPorNumCampaniaDTO> departamentoPorNumCampania() {
        return campaniaRepositorio.departamentoPorNumCampania();
    }
}
