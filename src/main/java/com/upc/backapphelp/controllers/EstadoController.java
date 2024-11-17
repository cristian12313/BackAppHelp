package com.upc.backapphelp.controllers;

import com.upc.backapphelp.dtos.EstadoDTO;
import com.upc.backapphelp.entities.Estado;
import com.upc.backapphelp.services.EstadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;
    @GetMapping("/estados")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE', 'ADMIN')")
    public List<EstadoDTO> listEstado() {
        List<Estado> list = estadoService.listEstado();
        ModelMapper modelMapper = new ModelMapper();
        List<EstadoDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }
    @PostMapping("/estado")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE', 'ADMIN')")
    public EstadoDTO insertEstado(@RequestBody EstadoDTO estadoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Estado estado = modelMapper.map(estadoDTO, Estado.class);
        estado = estadoService.insertEstado(estado);
        return modelMapper.map(estado, EstadoDTO.class);
    }

    @PutMapping("/estado")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE', 'ADMIN')")
    public EstadoDTO updateEstado(@RequestBody EstadoDTO estadoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Estado estado = modelMapper.map(estadoDTO, Estado.class);
        estado = estadoService.updateEstado(estado);
        return modelMapper.map(estado, EstadoDTO.class);
    }

    @DeleteMapping("/estado/{id}")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE', 'ADMIN')")
    public void eliminarEstado(@PathVariable int id) {
        estadoService.eliminar(id);
    }
    @GetMapping("/estado/{id}")
    public ResponseEntity<EstadoDTO> busca(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Estado estado = estadoService.buscarPorId(id);
        EstadoDTO estadoDTO = modelMapper.map(estado, EstadoDTO.class);
        return ResponseEntity.ok(estadoDTO);
    }
}
