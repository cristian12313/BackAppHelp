package com.upc.backapphelp.controllers;

import com.upc.backapphelp.dtos.CuentabancariaDTO;
import com.upc.backapphelp.entities.Cuentabancaria;
import com.upc.backapphelp.services.CuentabancariaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CuentabancariaController {
    @Autowired
    private CuentabancariaService cuentabancariaService;
    @GetMapping("/cuentabancarias")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE', 'ADMIN')")
    public List<CuentabancariaDTO> listarClientes() {
        List<Cuentabancaria> lista = cuentabancariaService.listarCuenta();
        ModelMapper modelMapper = new ModelMapper();
        List<CuentabancariaDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @PostMapping("/cuentabancaria")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE', 'ADMIN')")
    public CuentabancariaDTO insertarCuenta(@RequestBody CuentabancariaDTO cuentabancariaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Cuentabancaria cuentabancaria = modelMapper.map(cuentabancariaDTO, Cuentabancaria.class);
        cuentabancaria = cuentabancariaService.insertarCuenta(cuentabancaria);
        return modelMapper.map(cuentabancaria, CuentabancariaDTO.class);
    }

    @PutMapping("/cuentabancaria")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE', 'ADMIN')")
    public CuentabancariaDTO updateCuenta(@RequestBody CuentabancariaDTO cuentabancariaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Cuentabancaria cuentabancaria = modelMapper.map(cuentabancariaDTO, Cuentabancaria.class);
        cuentabancaria = cuentabancariaService.updateCuenta(cuentabancaria);
        return modelMapper.map(cuentabancaria, CuentabancariaDTO.class);
    }
    @DeleteMapping("/cuentabancaria/{id}")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE', 'ADMIN')")
    public void eliminarCuenta(@PathVariable int id) {
        cuentabancariaService.eliminar(id);
    }
    @GetMapping("/cuentabancaria/{id}")
    public ResponseEntity<CuentabancariaDTO> busca(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Cuentabancaria cuentabancaria = cuentabancariaService.buscarPorId(id);
        CuentabancariaDTO cuentabancariaDTO = modelMapper.map(cuentabancaria, CuentabancariaDTO.class);
        return ResponseEntity.ok(cuentabancariaDTO);
    }
}
