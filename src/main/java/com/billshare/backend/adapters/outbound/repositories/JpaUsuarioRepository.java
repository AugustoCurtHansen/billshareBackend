package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.adapters.outbound.entities.JpaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JpaUsuarioRepository extends JpaRepository<JpaUsuario,Long> {
    Optional<JpaUsuario> findByEmail(String email);
    boolean existsByEmail(String email);
}
