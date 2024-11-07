package com.gameshack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().permitAll() // Permite el acceso a todas las rutas sin autenticación
            .and()
            .csrf().disable(); // Desactiva CSRF temporalmente para facilitar pruebas

        return http.build();
    }
}
