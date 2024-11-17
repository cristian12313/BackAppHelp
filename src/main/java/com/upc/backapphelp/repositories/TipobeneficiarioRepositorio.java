package com.upc.backapphelp.repositories;

import com.upc.backapphelp.entities.Tipobeneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipobeneficiarioRepositorio extends JpaRepository<Tipobeneficiario,Long> {
}
