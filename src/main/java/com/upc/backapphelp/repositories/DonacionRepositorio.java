package com.upc.backapphelp.repositories;

import com.upc.backapphelp.dtos.*;
import com.upc.backapphelp.entities.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DonacionRepositorio extends JpaRepository<Donacion,Long> {
   //Visualizar las donaciones según el estado (parámetro) Donacion Por Estado
    @Query("select new com.upc.backapphelp.dtos.DonacionPorEstadoDTO(d.campania.nombre, d.tipodonacion.nombre) from Donacion d where d.estado.nombre=:pEstado group by d.campania.nombre, d.tipodonacion.nombre")
    public List<DonacionPorEstadoDTO> donacionesPorEstadoOrdFecha(@Param("pEstado") String pEstado);

    //Visualizar las donaciones para un donante Donacion Por Donante
    @Query("select new com.upc.backapphelp.dtos.DonacionPorDonanteDTO(d.campania.nombre, d.tipodonacion.nombre, d.distrito.nombre, d.estado.nombre) from Donacion d where d.user.dni=:pDni group by d.campania.nombre, d.tipodonacion.nombre, d.distrito.nombre, d.estado.nombre")
   public List<DonacionPorDonanteDTO> donacionesPorDonante(@Param("pDni") String pDni);

    //Visualizar las donaciones por campaña (parámetro) agrupadas por Donaciones Por Campaña
    @Query("select new com.upc.backapphelp.dtos.DonacionesPorCampañaDTO(count(d), d.tipodonacion.nombre) from Donacion d where d.campania.nombre=:pCampania group by  d.tipodonacion.nombre")
    public List<DonacionesPorCampañaDTO> donacionesPorCampañaOrdFecha(@Param("pCampania") String pCampania);

    //Visualizar donaciones por tipo de donación de las cuales la fecha de inicio se encuentre en un intervalo de tiempo
    @Query("select new com.upc.backapphelp.dtos.DonacionPorTipoEnIntervaloDTO(d.campania.nombre, d.estado.nombre,d.fechaInicio) from Donacion d where d.fechaInicio between :pFechaInicio and :pFechaFin group by d.tipodonacion.nombre, d.campania.nombre, d.estado.nombre, d.fechaInicio ")
    public List<DonacionPorTipoEnIntervaloDTO> donacionesPorTipoEnIntervalo(@Param("pFechaInicio")LocalDate pFechaInicio, @Param("pFechaFin") LocalDate pFechaFin);

    //Visualizar las recaudaciones en donaciones economicas por campaña
    @Query("select new com.upc.backapphelp.dtos.DonacionEcoRecaudacionDTO(count(d), sum(d.monto)) from Donacion d group by d.campania.nombre")
    public List<DonacionEcoRecaudacionDTO> donacionesEcoRecaudacionPorCampania ();

}
