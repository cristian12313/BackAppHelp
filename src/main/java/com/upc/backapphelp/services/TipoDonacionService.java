package com.upc.backapphelp.services;

import com.upc.backapphelp.entities.Tipodonacion;

import java.util.List;

public interface TipoDonacionService {
    public Tipodonacion insertTipoDonacion(Tipodonacion tipoDonacion);
    public List<Tipodonacion> listTipoDonacion();
    public Tipodonacion updateTipoDonacion(Tipodonacion tipoDonacion);
    public void eliminar(long id);
    public Tipodonacion buscarPorId(long id);
}
