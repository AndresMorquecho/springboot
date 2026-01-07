package com.krakedev.veterinaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.krakedev.veterinaria.entity.Mascota;

/* @RestController */
/* @RequestMapping("api/mascotas") */
public class MascotaController {

    private List<Mascota> mensajes = new ArrayList<>();

    public MascotaController() {
    
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
