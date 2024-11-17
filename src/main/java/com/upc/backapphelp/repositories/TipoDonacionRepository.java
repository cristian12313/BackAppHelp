package com.upc.backapphelp.repositories;

import com.upc.backapphelp.entities.Tipodonacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDonacionRepository extends JpaRepository<Tipodonacion, Long> {
}
