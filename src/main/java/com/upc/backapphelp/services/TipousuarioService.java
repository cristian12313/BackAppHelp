package com.upc.backapphelp.services;

import com.upc.backapphelp.entities.Tipousuario;

import java.util.List;

public interface TipousuarioService {
    public Tipousuario insetarTipousuario(Tipousuario tipousuario);
    public List<Tipousuario> listarTipousuario();
    public Tipousuario updateTipousuario(Tipousuario tipousuario);
    public void eliminar(long id);
    public Tipousuario buscarPorId(long id);
}
