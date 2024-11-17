package com.upc.backapphelp.controllers;

import com.upc.backapphelp.dtos.TipoDonacionDTO;
import com.upc.backapphelp.entities.Tipodonacion;
import com.upc.backapphelp.services.TipoDonacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class TipoDonacionController {
    @Autowired
    private TipoDonacionService tipoDonacionService;
    @GetMapping ("/tipoDonaciones")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public List<TipoDonacionDTO> listTipoDonacion() {
        List<Tipodonacion> list = tipoDonacionService.listTipoDonacion();
        ModelMapper modelMapper = new ModelMapper();
        List<TipoDonacionDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }
    @PostMapping("/tipoDonacion")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public TipoDonacionDTO insertTipoDonacion(@RequestBody TipoDonacionDTO tipoDonacionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Tipodonacion tipoDonacion = modelMapper.map(tipoDonacionDTO, Tipodonacion.class);
        tipoDonacion = tipoDonacionService.insertTipoDonacion(tipoDonacion);
        return modelMapper.map(tipoDonacion, TipoDonacionDTO.class);
    }

   @PutMapping ("/tipoDonacion")
   @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
   public TipoDonacionDTO updateTipoDonacion(@RequestBody TipoDonacionDTO tipoDonacionDTO) {
        ModelMapper modelMapper = new ModelMapper();
       Tipodonacion tipoDonacion = modelMapper.map(tipoDonacionDTO, Tipodonacion.class);
        tipoDonacion = tipoDonacionService.updateTipoDonacion(tipoDonacion);
        return modelMapper.map(tipoDonacion, TipoDonacionDTO.class);
   }
    @DeleteMapping("/tipoDonacion/{id}")
    @PreAuthorize("hasAnyRole('DAMNIFICADO', 'DONANTE')")
    public void eliminarTipoDona(@PathVariable int id) {
        tipoDonacionService.eliminar(id);
    }
    @GetMapping("/tipoDonacion/{id}")
    public ResponseEntity<TipoDonacionDTO> busca(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Tipodonacion tipodonacion = tipoDonacionService.buscarPorId(id);
        TipoDonacionDTO tipoDonacionDTO = modelMapper.map(tipodonacion, TipoDonacionDTO.class);
        return ResponseEntity.ok(tipoDonacionDTO);
    }
}
