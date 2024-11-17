package com.upc.backapphelp.controllers;

import com.upc.backapphelp.dtos.DepartamentoDTO;
import com.upc.backapphelp.entities.Departamento;
import com.upc.backapphelp.services.DepartamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;
    @GetMapping("/departamentos")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public List<DepartamentoDTO> listarDepartamento() {
        List<Departamento> lista = departamentoService.listarDepartamento();
        ModelMapper modelMapper = new ModelMapper();
        List<DepartamentoDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @PostMapping("/departamento")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public DepartamentoDTO insetarDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Departamento departamento = modelMapper.map(departamentoDTO, Departamento.class);
        departamento = departamentoService.insetarDepartamento(departamento);
        return modelMapper.map(departamento, DepartamentoDTO.class);
    }
    @PutMapping("/departamento")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public DepartamentoDTO updateDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Departamento departamento = modelMapper.map(departamentoDTO, Departamento.class);
        departamento = departamentoService.updateDepartamento(departamento);
        return modelMapper.map(departamento, DepartamentoDTO.class);
    }
    @DeleteMapping("/departamento/{id}")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public void eliminarDepartamento(@PathVariable int id) {
        departamentoService.eliminar(id);
    }
    @GetMapping("/departamento/{id}")
    public ResponseEntity<DepartamentoDTO> buscaProveedor(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Departamento departamento = departamentoService.buscarPorId(id);
        DepartamentoDTO departamentoDTO = modelMapper.map(departamento, DepartamentoDTO.class);
        return ResponseEntity.ok(departamentoDTO);
    }
}
