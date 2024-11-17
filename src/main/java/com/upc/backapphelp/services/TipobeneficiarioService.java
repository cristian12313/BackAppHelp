package com.upc.backapphelp.services;

import com.upc.backapphelp.entities.Tipobeneficiario;

import java.util.List;

public interface TipobeneficiarioService {
    public Tipobeneficiario insertarTipobeneficiario(Tipobeneficiario tipobeneficiario);
    public List<Tipobeneficiario> listarTipobeneficiario();
    public Tipobeneficiario updateTipobeneficiario(Tipobeneficiario tipobeneficiario);
    public void eliminar(long id);
    public Tipobeneficiario buscarPorId(long id);
}
