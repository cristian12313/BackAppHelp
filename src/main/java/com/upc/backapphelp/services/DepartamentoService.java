package com.upc.backapphelp.services;

import com.upc.backapphelp.entities.Departamento;

import java.util.List;

public interface DepartamentoService {
    public Departamento insetarDepartamento(Departamento departamento);
    public List<Departamento> listarDepartamento();
    public Departamento updateDepartamento(Departamento departamento);
    public void eliminar(long id);
    public Departamento buscarPorId(long id);
}
