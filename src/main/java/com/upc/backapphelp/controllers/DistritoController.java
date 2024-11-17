package com.upc.backapphelp.controllers;

import com.upc.backapphelp.dtos.DistritoDTO;
import com.upc.backapphelp.entities.Distrito;
import com.upc.backapphelp.services.DistritoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class DistritoController {
    @Autowired
    private DistritoService distritoService;
    @GetMapping("/distritos")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public List<DistritoDTO> listDistrito() {
        List<Distrito> list = distritoService.listDistrito();
        ModelMapper modelMapper = new ModelMapper();
        List<DistritoDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }
    @PostMapping("/distrito")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public DistritoDTO insertDistrito(@RequestBody DistritoDTO distritoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Distrito distrito = modelMapper.map(distritoDTO, Distrito.class);
        distrito = distritoService.insertDistrito(distrito);
        return modelMapper.map(distrito, DistritoDTO.class);
    }

    @PutMapping("/distrito")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public DistritoDTO updateDistrito(@RequestBody DistritoDTO distritoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Distrito distrito = modelMapper.map(distritoDTO, Distrito.class);
        distrito = distritoService.updateDistrito(distrito);
        return modelMapper.map(distrito, DistritoDTO.class);
    }

    @DeleteMapping("/distrito/{id}")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public void eliminarDistrito(@PathVariable int id) {
        distritoService.eliminar(id);
    }
    @GetMapping("/distrito/{id}")
    public ResponseEntity<DistritoDTO> busca(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Distrito distrito = distritoService.buscarPorId(id);
        DistritoDTO distritoDTO = modelMapper.map(distrito, DistritoDTO.class);
        return ResponseEntity.ok(distritoDTO);
    }

}
