package com.upc.backapphelp.services;

import com.upc.backapphelp.entities.Estado;

import java.util.List;

public interface EstadoService {
    public Estado insertEstado(Estado estado);
    public List<Estado> listEstado();
    public Estado updateEstado(Estado estado);
    public void eliminar(long id);
    public Estado buscarPorId(long id);
}
