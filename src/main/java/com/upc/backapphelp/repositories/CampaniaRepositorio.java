package com.upc.backapphelp.repositories;

import com.upc.backapphelp.dtos.CampaniaPorCulminadoPorDepaDTO;
import com.upc.backapphelp.dtos.DepartamentoPorNumCampaniaDTO;
import com.upc.backapphelp.entities.Campania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaniaRepositorio extends JpaRepository<Campania,Long> {
    //Visualizar campañas culminadas o no (parámetro) por cada departamento
    @Query("select new com.upc.backapphelp.dtos.CampaniaPorCulminadoPorDepaDTO(c.nombre, c.distrito.nombre, c.user.dni, c.tipodonacion.nombre, c.tipobeneficiario.nombre) from Campania c where c.culminado=:pCulminado group by c.nombre, c.distrito.nombre, c.user.dni, c.tipodonacion.nombre, c.tipobeneficiario.nombre, c.distrito.departamento.nombreDepartamento")
    public List<CampaniaPorCulminadoPorDepaDTO> campaniasPorCulminadoPorDepartamento(@Param("pCulminado") Boolean pCulminado);


    //Visualizar departamentos ordenados del que presenta mayor número de campañas al menor
    @Query("select new com.upc.backapphelp.dtos.DepartamentoPorNumCampaniaDTO(c.distrito.departamento.nombreDepartamento, count(c)) from Campania c group by c.distrito.departamento.nombreDepartamento order by count(c)")
    public List<DepartamentoPorNumCampaniaDTO> departamentoPorNumCampania();
}
