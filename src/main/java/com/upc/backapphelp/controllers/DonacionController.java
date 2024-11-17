package com.upc.backapphelp.controllers;

import com.upc.backapphelp.dtos.*;
import com.upc.backapphelp.entities.Donacion;
import com.upc.backapphelp.services.DonacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class DonacionController {
    @Autowired
    private DonacionService donacionService;
    @GetMapping("/donaciones")
    @PreAuthorize("hasAnyRole('ADMIN', 'DONANTE')")
    public List<DonacionDTO> listarDonacion() {
        List<Donacion> lista = donacionService.listarDonacion();
        ModelMapper modelMapper = new ModelMapper();
        List<DonacionDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @PostMapping("/donacion")
    @PreAuthorize("hasRole('DONANTE')")
    public DonacionDTO insertarDonacion(@RequestBody DonacionDTO donacionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Donacion donacion = modelMapper.map(donacionDTO, Donacion.class);
        donacion = donacionService.insertarDonacion(donacion);
        return modelMapper.map(donacion, DonacionDTO.class);
    }

    @PutMapping("/donacion")
    @PreAuthorize("hasRole('DONANTE')")
    public DonacionDTO updateDonacion(@RequestBody DonacionDTO donacionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Donacion donacion = modelMapper.map(donacionDTO, Donacion.class);
        donacion = donacionService.updateDonacion(donacion);
        return modelMapper.map(donacion, DonacionDTO.class);
    }
    @DeleteMapping("/donacion/{id}")
    @PreAuthorize("hasRole('DONANTE')")
    public void eliminarDonacion(@PathVariable int id) {
        donacionService.eliminar(id);
    }
    @GetMapping("/donacion/{id}")
    public ResponseEntity<DonacionDTO> buscaDonacion(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Donacion donacion = donacionService.buscarPorId(id);
        DonacionDTO donacionDTO = modelMapper.map(donacion, DonacionDTO.class);
        return ResponseEntity.ok(donacionDTO);
    }

    @GetMapping("/donacionesPorEstadoOrdFecha/{pEstado}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<DonacionPorEstadoDTO> donacionesPorEstadoOrdFecha(@PathVariable String pEstado) {
        return donacionService.donacionesPorEstadoOrdFecha(pEstado);
    }

    @GetMapping("/donacionesPorCampaniaOrdFecha/{pCampania}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<DonacionesPorCampañaDTO> donacionesPorCampañaOrdFecha(@PathVariable String pCampania) {
        return donacionService.donacionesPorCampañaOrdFecha(pCampania);
    }

    @GetMapping("/donacionPorDonante/{pDni}")
    public List<DonacionPorDonanteDTO> donacionesPorDonante(@PathVariable String pDni) {
        return donacionService.donacionesPorDonante(pDni);
    }

    @GetMapping("/donacionesPorTipoEnIntervalo/{pFechaInicio},{pFechaFin}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<DonacionPorTipoEnIntervaloDTO> donacionesPorTipoEnIntervalo(@PathVariable LocalDate pFechaInicio,@PathVariable LocalDate pFechaFin) {
        return donacionService.donacionesPorTipoEnIntervalo(pFechaInicio, pFechaFin);
    }

    @GetMapping("/donacionesEcoRecaudacionPorCampania/")
    @PreAuthorize("hasRole('ADMIN')")
    public List<DonacionEcoRecaudacionDTO> donacionesEcoRecaudacionPorCampania() {
        return donacionService.donacionesEcoRecaudacionPorCampania();
    }
}
