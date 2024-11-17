package com.upc.backapphelp.services;

import com.upc.backapphelp.entities.Cuentabancaria;

import java.util.List;

public interface CuentabancariaService {
    public Cuentabancaria insertarCuenta(Cuentabancaria cuentabancaria);
    public List<Cuentabancaria> listarCuenta();
    public Cuentabancaria updateCuenta(Cuentabancaria cuentabancaria);
    public void eliminar(long id);
    public Cuentabancaria buscarPorId(long id);
}
