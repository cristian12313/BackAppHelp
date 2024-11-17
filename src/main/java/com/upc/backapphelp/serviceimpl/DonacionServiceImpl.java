package com.upc.backapphelp.serviceimpl;

import com.upc.backapphelp.dtos.*;
import com.upc.backapphelp.entities.Donacion;
import com.upc.backapphelp.repositories.DonacionRepositorio;
import com.upc.backapphelp.services.DonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DonacionServiceImpl implements DonacionService {
    @Autowired
    private DonacionRepositorio donacionRepositorio;
    @Override
    public Donacion insertarDonacion(Donacion donacion) {
        return donacionRepositorio.save(donacion);
    }

    @Override
    public List<Donacion> listarDonacion() {
        return donacionRepositorio.findAll();
    }

    @Override
    public Donacion updateDonacion(Donacion donacion) {
        if(donacionRepositorio.existsById(donacion.getIdDonacion())){
            return donacionRepositorio.save(donacion);
        }
        return null;
    }

    @Override
    public void eliminar(long id) {
        if(donacionRepositorio.findById(id).isPresent()){
            donacionRepositorio.deleteById(id);
        }
    }
    @Override
    public Donacion buscarPorId(long id) {
        if(donacionRepositorio.findById(id).isPresent()){
            return donacionRepositorio.findById(id).get();
        }
        return null;
    }

    @Override
    public List<DonacionPorEstadoDTO> donacionesPorEstadoOrdFecha(String pEstado) {
        return donacionRepositorio.donacionesPorEstadoOrdFecha(pEstado);
    }

    @Override
    public List<DonacionPorDonanteDTO> donacionesPorDonante(String pDni) {
        return donacionRepositorio.donacionesPorDonante(pDni);
    }

    @Override
    public List<DonacionesPorCampañaDTO> donacionesPorCampañaOrdFecha(String pCampania) {
        return donacionRepositorio.donacionesPorCampañaOrdFecha(pCampania);
    }

    @Override
    public List<DonacionPorTipoEnIntervaloDTO> donacionesPorTipoEnIntervalo(LocalDate pFechaInicio, LocalDate pFechaFin) {
        return donacionRepositorio.donacionesPorTipoEnIntervalo(pFechaInicio, pFechaFin);
    }

    @Override
    public List<DonacionEcoRecaudacionDTO> donacionesEcoRecaudacionPorCampania() {
        return donacionRepositorio.donacionesEcoRecaudacionPorCampania();
    }
}
