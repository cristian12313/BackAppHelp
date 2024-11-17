package com.upc.backapphelp.repositories;
import com.upc.backapphelp.entities.Tipousuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipousuarioRepositorio extends JpaRepository<Tipousuario, Long> {
}
