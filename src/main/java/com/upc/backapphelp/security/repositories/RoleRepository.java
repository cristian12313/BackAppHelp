package com.upc.backapphelp.security.repositories;
import com.upc.backapphelp.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
