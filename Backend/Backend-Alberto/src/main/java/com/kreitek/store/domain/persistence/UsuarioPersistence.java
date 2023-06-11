package com.kreitek.store.domain.persistence;

import com.kreitek.store.domain.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioPersistence {

    List<Usuario> getAllUsers();

    List<Usuario> getAllUsersById(Long userid);

    Usuario saveUser(Usuario usuario);

    Optional<Usuario> getUserById(Long userid);

    Optional<Usuario> findUserByEmail(String email);
}
