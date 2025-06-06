package com.billshare.backend.domain.userContext;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findAllActiveUsers();
    void delete(Usuario usuario);

    Long contagemDeLoginPorMesEUsuario(Long month, Long userId);
    boolean existsByEmailAndActiveTrue(String email);
}
