package com.GameShack;

import com.gameshack.repository.UsuarioRepository;
import com.gameshack.model.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class GameShackApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameShackApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UsuarioRepository usuarioRepository) {
        return args -> {
            // Verifica si el usuario ya existe en la base de datos para evitar duplicados
            if (usuarioRepository.findByEmailAndPassword("test@email.com", "password123").isEmpty()) {
                Usuario usuario = new Usuario();
                usuario.setNombre("usuario_test");
                usuario.setEmail("test@email.com");
                usuario.setPassword("password123"); // En producción, usa una contraseña encriptada
                usuarioRepository.save(usuario);
            }
        };
    }
}