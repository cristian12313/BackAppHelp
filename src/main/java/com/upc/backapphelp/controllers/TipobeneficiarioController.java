package com.upc.backapphelp.controllers;

import com.upc.backapphelp.dtos.TipobeneficiarioDTO;
import com.upc.backapphelp.entities.Tipobeneficiario;
import com.upc.backapphelp.services.TipobeneficiarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class TipobeneficiarioController {
    @Autowired
    private TipobeneficiarioService tipobeneficiarioService;
    @GetMapping("/tipobeneficiarios")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public List<TipobeneficiarioDTO> listarTipobeneficiario() {
        List<Tipobeneficiario> lista = tipobeneficiarioService.listarTipobeneficiario();
        ModelMapper modelMapper = new ModelMapper();
        List<TipobeneficiarioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @PostMapping("/tipobeneficiario")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public TipobeneficiarioDTO insertarTipobeneficiario(@RequestBody TipobeneficiarioDTO tipobeneficiarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Tipobeneficiario tipobeneficiario = modelMapper.map(tipobeneficiarioDTO, Tipobeneficiario.class);
        tipobeneficiario = tipobeneficiarioService.insertarTipobeneficiario(tipobeneficiario);
        return modelMapper.map(tipobeneficiario, TipobeneficiarioDTO.class);
    }

    @PutMapping("/tipobeneficiario")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public TipobeneficiarioDTO updateTipobeneficiario(@RequestBody TipobeneficiarioDTO tipobeneficiarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Tipobeneficiario tipobeneficiario = modelMapper.map(tipobeneficiarioDTO, Tipobeneficiario.class);
        tipobeneficiario = tipobeneficiarioService.updateTipobeneficiario(tipobeneficiario);
        return modelMapper.map(tipobeneficiario, TipobeneficiarioDTO.class);
    }
    @DeleteMapping("/tipobeneficiario/{id}")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public void eliminarTipoBen(@PathVariable int id) {
        tipobeneficiarioService.eliminar(id);
    }
    @GetMapping("/tipobeneficiario/{id}")
    public ResponseEntity<TipobeneficiarioDTO> busca(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Tipobeneficiario tipobeneficiario = tipobeneficiarioService.buscarPorId(id);
        TipobeneficiarioDTO tipobeneficiarioDTO = modelMapper.map(tipobeneficiario, TipobeneficiarioDTO.class);
        return ResponseEntity.ok(tipobeneficiarioDTO);
    }
}
