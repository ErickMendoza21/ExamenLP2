package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class Cors {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Configura los orígenes permitidos. Puedes ajustar esto según tus necesidades.
        config.addAllowedOrigin("http://localhost:4200");

        // Configura los métodos HTTP permitidos (GET, POST, PUT, DELETE, etc.).
        config.addAllowedMethod("*");

        // Configura los encabezados permitidos.
        config.addAllowedHeader("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    }