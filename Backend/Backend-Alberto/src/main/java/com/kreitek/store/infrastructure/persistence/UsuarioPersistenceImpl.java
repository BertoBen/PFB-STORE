package com.kreitek.store.infrastructure.persistence;

import com.kreitek.store.domain.entity.Usuario;
import com.kreitek.store.domain.persistence.UsuarioPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioPersistenceImpl implements UsuarioPersistence {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioPersistenceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public List<Usuario> getAllUsers() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> getAllUsersById(Long userid) {
        return this.usuarioRepository.findAllByUserid(userid);
    }

    @Override
    public Usuario saveUser(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> getUserById(Long userid) {
        return this.usuarioRepository.findById(userid);
    }

    @Override
    public Optional<Usuario> findUserByEmail(String email) {
        return this.usuarioRepository.findByEmail(email);
    }

}
