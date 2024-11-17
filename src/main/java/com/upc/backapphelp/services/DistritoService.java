package com.upc.backapphelp.services;

import com.upc.backapphelp.entities.Distrito;

import java.util.List;

public interface DistritoService {
    public Distrito insertDistrito(Distrito distrito);
    public List<Distrito> listDistrito();
    public Distrito updateDistrito(Distrito distrito);
    public void eliminar(long id);
    public Distrito buscarPorId(long id);
}
