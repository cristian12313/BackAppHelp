package com.upc.backapphelp.controllers;

import com.upc.backapphelp.dtos.CampaniaDTO;
import com.upc.backapphelp.dtos.TipousuarioDTO;
import com.upc.backapphelp.entities.Campania;
import com.upc.backapphelp.entities.Tipousuario;
import com.upc.backapphelp.services.TipousuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class TipousuarioController {
    @Autowired
    private TipousuarioService tipousuarioService;
    @GetMapping("/tipousuarios")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public List<TipousuarioDTO> listar() {
        List<Tipousuario> lista = tipousuarioService.listarTipousuario();
        ModelMapper modelMapper = new ModelMapper();
        List<TipousuarioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @PostMapping("/tipousuario")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public TipousuarioDTO insetarTipousuario(@RequestBody TipousuarioDTO tipousuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Tipousuario tipousuario = modelMapper.map(tipousuarioDTO, Tipousuario.class);
        tipousuario = tipousuarioService.insetarTipousuario(tipousuario);
        return modelMapper.map(tipousuario, TipousuarioDTO.class);
    }
    @PutMapping("/tipousuario")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public TipousuarioDTO update(@RequestBody TipousuarioDTO tipousuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Tipousuario tipousuario = modelMapper.map(tipousuarioDTO, Tipousuario.class);
        tipousuario = tipousuarioService.updateTipousuario(tipousuario);
        return modelMapper.map(tipousuario, TipousuarioDTO.class);
    }
    @DeleteMapping("/tipousuario/{id}")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public void eliminarTipoUsuario(@PathVariable int id) {
        tipousuarioService.eliminar(id);
    }
    @GetMapping("/tipousuario/{id}")
    public ResponseEntity<TipousuarioDTO> busca(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Tipousuario tipousuario = tipousuarioService.buscarPorId(id);
        TipousuarioDTO tipousuarioDTO = modelMapper.map(tipousuario, TipousuarioDTO.class);
        return ResponseEntity.ok(tipousuarioDTO);
    }

}
