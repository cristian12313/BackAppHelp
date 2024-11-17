package com.upc.backapphelp.repositories;

import com.upc.backapphelp.entities.Cuentabancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentabancariaRepositorio extends JpaRepository<Cuentabancaria, Long> {

}
