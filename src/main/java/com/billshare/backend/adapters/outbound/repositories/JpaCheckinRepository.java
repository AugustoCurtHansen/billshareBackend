package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.adapters.outbound.entities.JpaCheckin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface JpaCheckinRepository extends JpaRepository<JpaCheckin,Long> {
    List<JpaCheckin> findAllByIdUsuario(Long idUsuario);
    List<JpaCheckin> findByIdUsuarioAndDiaHoraCheckinBetween(Long idUsuario, LocalDateTime inicio, LocalDateTime fim);
}
