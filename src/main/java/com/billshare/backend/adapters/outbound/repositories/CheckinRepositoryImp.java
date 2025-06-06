package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.adapters.outbound.entities.JpaCheckin;
import com.billshare.backend.domain.userContext.Checkin;
import com.billshare.backend.domain.userContext.CheckinRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import java.time.LocalDate;
import java.util.*;

@Repository
public class CheckinRepositoryImp implements CheckinRepository {

    private final JpaCheckinRepository repository;

    public CheckinRepositoryImp(JpaCheckinRepository repository) {
        this.repository = repository;
    }

    private Checkin toDomain(JpaCheckin entity) {
        Checkin c = new Checkin(entity.getDiaHoraCheckin());
        c.setId(entity.getId());
        c.setIdUsuario(entity.getIdUsuario());
        return c;
    }

    private JpaCheckin toJpa(Checkin checkin) {
        return new JpaCheckin(checkin.getId(), checkin.getIdUsuario(), checkin.getDiaHoraCheckin());
    }

    @Override
    public Checkin save(Checkin checkin) {
        JpaCheckin saved = repository.save(toJpa(checkin));
        return toDomain(saved);
    }

    @Override
    public Optional<List<Checkin>> findAllCheckinsByUser(long idUser) {
        List<JpaCheckin> result = repository.findAllByIdUsuario(idUser);
        return Optional.of(result.stream().map(this::toDomain).toList());
    }

    @Override
    public Optional<List<Checkin>> findByUserIdAndPeriod(long userId, LocalDate start, LocalDate end) {
        LocalDateTime inicio = start.atStartOfDay();
        LocalDateTime fim = end.plusDays(1).atStartOfDay();
        List<JpaCheckin> result = repository.findByIdUsuarioAndDiaHoraCheckinBetween(userId, inicio, fim);
        return Optional.of(result.stream().map(this::toDomain).toList());
    }
}
