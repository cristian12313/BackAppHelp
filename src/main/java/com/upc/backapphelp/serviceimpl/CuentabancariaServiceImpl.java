package com.upc.backapphelp.serviceimpl;

import com.upc.backapphelp.entities.Cuentabancaria;
import com.upc.backapphelp.repositories.CuentabancariaRepositorio;
import com.upc.backapphelp.services.CuentabancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentabancariaServiceImpl implements CuentabancariaService {
   @Autowired
   private CuentabancariaRepositorio cuentabancariaRepositorio;
    @Override
    public Cuentabancaria insertarCuenta(Cuentabancaria cuentabancaria) {
        return cuentabancariaRepositorio.save(cuentabancaria);
    }

    @Override
    public List<Cuentabancaria> listarCuenta( ) {
        return cuentabancariaRepositorio.findAll();
    }

    @Override
    public Cuentabancaria updateCuenta(Cuentabancaria cuentabancaria) {
        if(cuentabancariaRepositorio.existsById(cuentabancaria.getIdCuentaBanc())){
            return cuentabancariaRepositorio.save(cuentabancaria);
        }
        return null;
    }
    @Override
    public void eliminar(long id) {
        if(cuentabancariaRepositorio.findById(id).isPresent()){
            cuentabancariaRepositorio.deleteById(id);
        }
    }
    @Override
    public Cuentabancaria buscarPorId(long id) {
        if(cuentabancariaRepositorio.findById(id).isPresent()){
            return cuentabancariaRepositorio.findById(id).get();
        }
        return null;
    }
}
