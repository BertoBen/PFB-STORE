package com.kreitek.store.infrastructure.persistence;

import com.kreitek.store.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByUserid(Long userid);

    Optional<Usuario> findByEmail(String email);

}
