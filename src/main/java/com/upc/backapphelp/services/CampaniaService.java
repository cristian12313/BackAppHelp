package com.upc.backapphelp.services;

import com.upc.backapphelp.dtos.CampaniaPorCulminadoPorDepaDTO;
import com.upc.backapphelp.dtos.DepartamentoPorNumCampaniaDTO;
import com.upc.backapphelp.entities.Campania;

import java.util.List;

public interface CampaniaService {
    public Campania insertarCampania(Campania campania);
    public List<Campania> listarCampania();
    public Campania updateCampania(Campania campania);
    public void eliminar(long id);
    public Campania buscarPorId(long id);
    public List<CampaniaPorCulminadoPorDepaDTO> campaniasPorCulminadoPorDepartamento(Boolean pCulminado);
    public List<DepartamentoPorNumCampaniaDTO> departamentoPorNumCampania();
}
