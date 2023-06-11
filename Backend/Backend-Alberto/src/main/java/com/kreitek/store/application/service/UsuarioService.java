package com.kreitek.store.application.service;

import com.kreitek.store.application.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<UsuarioDTO> getAllUsers();
    List<UsuarioDTO> getAllUsersById(Long userid);
    Optional<UsuarioDTO> getUserById(Long userid);
    UsuarioDTO saveUser(UsuarioDTO usuarioDTO);

    Optional<UsuarioDTO> authenticateUser(UsuarioDTO usuarioDTO);

}
