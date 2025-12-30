package com.krakedev.veterinaria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

//Controlador REST: Esa es una clase en Java que expone rutas HTTP para manejar solicitudes y respuestas en una aplicación web.

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/veterinaria")
public class VeterinariaController {

    @GetMapping("/bienvenida") // Mapea las solicitudes GET a /micontroler/saludo
    public String saludar() {
        return "Bienvenido al Sistema de Gestión Veterinaria";
    }

}
