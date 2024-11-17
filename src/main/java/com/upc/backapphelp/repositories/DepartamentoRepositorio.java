package com.upc.backapphelp.repositories;

import com.upc.backapphelp.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento,Long> {
}
