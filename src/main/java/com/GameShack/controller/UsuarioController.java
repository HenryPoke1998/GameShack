package com.gameshack.controller;

import com.gameshack.model.Usuario;
import com.gameshack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PostMapping("/login")
    public Usuario loginUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword())
                .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));
    }
}
