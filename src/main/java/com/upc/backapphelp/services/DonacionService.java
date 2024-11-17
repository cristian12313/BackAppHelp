package com.upc.backapphelp.services;

import com.upc.backapphelp.dtos.*;
import com.upc.backapphelp.entities.Donacion;

import java.time.LocalDate;
import java.util.List;

public interface DonacionService {
    public Donacion insertarDonacion(Donacion donacion);
    public List<Donacion> listarDonacion();
    public Donacion updateDonacion(Donacion donacion);
    public Donacion buscarPorId(long id);
    public List<DonacionPorEstadoDTO> donacionesPorEstadoOrdFecha(String pEstado);
    public List<DonacionPorDonanteDTO> donacionesPorDonante(String pDni);
    public List<DonacionesPorCampañaDTO> donacionesPorCampañaOrdFecha(String pCampania);
    public List<DonacionPorTipoEnIntervaloDTO> donacionesPorTipoEnIntervalo(LocalDate pFechaInicio, LocalDate pFechaFin);
    public List<DonacionEcoRecaudacionDTO> donacionesEcoRecaudacionPorCampania();
    public void eliminar(long id);
}
