package com.kreitek.store.infrastructure.rest;

import com.kreitek.store.application.dto.UsuarioDTO;
import com.kreitek.store.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UsuarioRestController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @CrossOrigin
    @GetMapping(value = "/users", produces = "application/json")
    ResponseEntity<List<UsuarioDTO>> getAllUsers() {
        List<UsuarioDTO> users = this.usuarioService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/users/{userid}", produces = "application/json")
    ResponseEntity<List<UsuarioDTO>> getAllUsersById(@PathVariable Long userid) {
        List<UsuarioDTO> users = this.usuarioService.getAllUsersById(userid);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param usuarioDTO Objeto UsuarioDTO que contiene los datos del usuario a registrar
     * @return ResponseEntity con el UsuarioDTO registrado y el estado HTTP
     */
    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> registerUser(@RequestBody UsuarioDTO usuarioDTO) {
        System.out.println(usuarioDTO.toString());
        UsuarioDTO userRegistered = this.usuarioService.saveUser(usuarioDTO);
        return new ResponseEntity<>(userRegistered, HttpStatus.CREATED);
    }


    /**
     * Autentica un usuario en el sistema.
     *
     * @param usuarioDTO Objeto UsuarioDTO que contiene los datos del usuario a autenticar
     * @return ResponseEntity con el UsuarioDTO autenticado si es exitoso, o estado HTTP UNAUTHORIZED si no lo es
     */
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> loginUser(@RequestBody UsuarioDTO usuarioDTO) {
        Optional<UsuarioDTO> authenticatedUser = this.usuarioService.authenticateUser(usuarioDTO);
        if (authenticatedUser.isPresent()) {
            return new ResponseEntity<>(authenticatedUser.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @CrossOrigin
    @GetMapping (value = "")
    ResponseEntity<UsuarioDTO> getUserById(@PathVariable Long userid) {
        Optional<UsuarioDTO> usuario = this.usuarioService.getUserById(userid);

        if (usuario.isPresent()) {
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

