package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.adapters.outbound.entities.JpaUsuario;
import com.billshare.backend.adapters.outbound.repositories.JpaUsuarioRepository;
import com.billshare.backend.domain.userContext.EUserRoles;
import com.billshare.backend.domain.userContext.Usuario;
import com.billshare.backend.domain.userContext.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UserRepository {

    private final JpaUsuarioRepository userRepository;
    public UsuarioRepositoryImpl(JpaUsuarioRepository userRepository){
        this.userRepository = userRepository;
    }

    private Usuario convertToDomain(JpaUsuario jpaUser) {
        Usuario user = new Usuario(jpaUser.getUserName(), jpaUser.getEmail(), EUserRoles.DEFAULT);
        user.setId(jpaUser.getId());
        return user;
    }

    private JpaUsuario convertToJpa(Usuario usuario) {
        return new JpaUsuario(usuario.getId(), usuario.getUserName(), usuario.getEmail());
    }

    @Override
    public Long contagemDeLoginPorMesEUsuario(Long month, Long userId){
       //return userRepository.findAllById(userId).
        return 0L;
    }

    @Override
    public Usuario save(Usuario usuario) {
        JpaUsuario saved = userRepository.save(convertToJpa(usuario));
        return convertToDomain(saved);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return userRepository.findById(id).map(this::convertToDomain);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return userRepository.findByEmail(email).map(this::convertToDomain);
    }

    @Override
    public List<Usuario> findAllActiveUsers() {
        return userRepository.findAll().stream().map(this::convertToDomain).toList();
    }

    @Override
    public void delete(Usuario usuario) {
        userRepository.delete(convertToJpa(usuario));
    }

    @Override
    public boolean existsByEmailAndActiveTrue(String email) {
        return userRepository.existsByEmail(email);
    }
}
