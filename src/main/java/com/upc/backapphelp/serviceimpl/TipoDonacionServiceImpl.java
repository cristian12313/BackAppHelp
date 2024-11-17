package com.upc.backapphelp.serviceimpl;

import com.upc.backapphelp.entities.Tipodonacion;
import com.upc.backapphelp.repositories.TipoDonacionRepository;
import com.upc.backapphelp.services.TipoDonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDonacionServiceImpl implements TipoDonacionService {
    @Autowired
    private TipoDonacionRepository tipoDonacionRepository;

    @Override
    public Tipodonacion insertTipoDonacion(Tipodonacion tipodonacion) {
        return tipoDonacionRepository.save(tipodonacion);
    }

    @Override
    public List<Tipodonacion> listTipoDonacion() {
        return tipoDonacionRepository.findAll();
    }

    @Override
    public Tipodonacion updateTipoDonacion(Tipodonacion tipoDonacion) {
        if(tipoDonacionRepository.existsById(tipoDonacion.getIdTipodonacion())){
            return tipoDonacionRepository.save(tipoDonacion);
        }
        return null;
    }
    @Override
    public void eliminar(long id) {
        if(tipoDonacionRepository.findById(id).isPresent()){
            tipoDonacionRepository.deleteById(id);
        }
    }
    @Override
    public Tipodonacion buscarPorId(long id) {
        if(tipoDonacionRepository.findById(id).isPresent()){
            return tipoDonacionRepository.findById(id).get();
        }
        return null;
    }
}
