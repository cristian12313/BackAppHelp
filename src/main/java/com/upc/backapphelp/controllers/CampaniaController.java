package com.upc.backapphelp.controllers;

import com.upc.backapphelp.dtos.CampaniaDTO;
import com.upc.backapphelp.dtos.CampaniaPorCulminadoPorDepaDTO;
import com.upc.backapphelp.dtos.DepartamentoPorNumCampaniaDTO;
import com.upc.backapphelp.entities.Campania;
import com.upc.backapphelp.services.CampaniaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CampaniaController {
    @Autowired
    private CampaniaService campaniaService;
    @GetMapping("/campanias")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE', 'ADMIN')")
    public List<CampaniaDTO> listarCampania() {
        List<Campania> lista = campaniaService.listarCampania();
        ModelMapper modelMapper = new ModelMapper();
        List<CampaniaDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @PostMapping("/campania")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public CampaniaDTO insertarCampania(@RequestBody CampaniaDTO campaniaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Campania campania = modelMapper.map(campaniaDTO, Campania.class);
        campania = campaniaService.insertarCampania(campania);
        return modelMapper.map(campania, CampaniaDTO.class);
    }
    @PutMapping("/campania")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public CampaniaDTO updateCampania(@RequestBody CampaniaDTO campaniaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Campania campania = modelMapper.map(campaniaDTO, Campania.class);
        campania = campaniaService.updateCampania(campania);
        return modelMapper.map(campania, CampaniaDTO.class);
    }
    @DeleteMapping("/campania/{id}")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public void eliminarCampania(@PathVariable int id) {
        campaniaService.eliminar(id);
    }

    @GetMapping("/campania/{id}")
    public ResponseEntity<CampaniaDTO> buscaCampania(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Campania campania = campaniaService.buscarPorId(id);
        CampaniaDTO campaniaDTO = modelMapper.map(campania, CampaniaDTO.class);
        return ResponseEntity.ok(campaniaDTO);
    }

    @GetMapping("/campaniasPorCulminadoPorDepartamento/{pCulminado}")
    public List<CampaniaPorCulminadoPorDepaDTO> campaniasPorCulminadoPorDepartamento(Boolean pCulminado) {
        return campaniaService.campaniasPorCulminadoPorDepartamento(pCulminado);
    }

    @GetMapping("/departamentoPorNumCampania")
    public List<DepartamentoPorNumCampaniaDTO> departamentoPorNumCampania() {
        return campaniaService.departamentoPorNumCampania();
    }
}
