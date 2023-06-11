package com.kreitek.store.application.service.impl;

import com.kreitek.store.application.dto.UsuarioDTO;
import com.kreitek.store.application.mapper.UsuarioMapper;
import com.kreitek.store.application.service.UsuarioService;
import com.kreitek.store.domain.entity.Usuario;
import com.kreitek.store.domain.persistence.UsuarioPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioPersistence persistence;

    private final UsuarioMapper mapper;

    @Autowired
    public UsuarioServiceImpl(UsuarioPersistence persistence, UsuarioMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public Optional<UsuarioDTO> authenticateUser(UsuarioDTO usuarioDTO) {
        Optional<Usuario> existingUser = this.persistence.findUserByEmail(usuarioDTO.getEmail());
        if (existingUser.isPresent() && existingUser.get().getPassword().equals(usuarioDTO.getPassword())) {
            // Si el usuario existe y la contraseña es correcta, devuelve el UsuarioDTO
            return Optional.of(this.mapper.toDto(existingUser.get()));
        } else {
            // Si el usuario no existe o la contraseña no es correcta, devuelve un Optional vacío
            return Optional.empty();
        }
    }


    @Override
    public List<UsuarioDTO> getAllUsers() {
        List<Usuario> users = this.persistence.getAllUsers();
        return this.mapper.toDto(users);
    }

    @Override
    public List<UsuarioDTO> getAllUsersById(Long userid) {
        List<Usuario> users = this.persistence.getAllUsersById(userid);
        return this.mapper.toDto(users);
    }

    @Override
    public Optional<UsuarioDTO> getUserById(Long userid) {
        return this.persistence.getUserById(userid).map(mapper::toDto);
    }


    @Override
    public UsuarioDTO saveUser(UsuarioDTO usuarioDTO) {
        Usuario userSaved = this.persistence.saveUser(this.mapper.toEntity(usuarioDTO));
        return this.mapper.toDto(userSaved);
    }
}


