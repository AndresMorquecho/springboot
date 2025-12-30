package com.krakedev.veterinaria.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinaria.entity.Mascota;

@RestController
@RequestMapping("api/mascotas")
public class MascotaController {

    private List<Mascota> mensajes = new ArrayList<>();

    public MascotaController() {
        mensajes.add(new Mascota(1L, "Firulais", "Perro", 3, "Juan Perez", LocalDate.now()));
        mensajes.add(new Mascota(2L, "Michi", "Gato", 2, "Maria Gomez", LocalDate.now()));
        mensajes.add(new Mascota(3L, "Nemo", "Pez", 1, "Carlos Lopez", LocalDate.now()));
        mensajes.add(new Mascota(4L, "Bruno", "Perro", 7, "Andres Israel", LocalDate.now()));
        mensajes.add(new Mascota(5L, "Max", "Perro", 7, "Nicoletta", LocalDate.now()));
    }

    @GetMapping
    public List<Mascota> getAllMessages() {
        return mensajes;
    }

    @GetMapping("/{id}")
    public Mascota getMessageByid(@PathVariable int id) {

        Optional<Mascota> mensaje = mensajes.stream().filter(m -> m.getId() == id).findFirst();

        return mensaje.orElse(null);

    }

    @PostMapping
    public Mascota crearMessage(@RequestBody Mascota message) {
        mensajes.add(message);

        return message;
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable int id) {
        mensajes.removeIf(m -> m.getId() == id);
    }

}
