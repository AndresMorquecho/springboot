package com.krakedev.veterinaria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinaria.entity.Mascota;
import com.krakedev.veterinaria.services.VeterinariaServices;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("api/mascotas")
@RequiredArgsConstructor
public class MascotasController {

    private final VeterinariaServices veterinariaServices;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarMascota(@RequestBody Mascota newMascota) {

        Mascota nuevaMascota = veterinariaServices.RegistrarMascota(newMascota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);

    }

    @GetMapping
    public ResponseEntity<List<Mascota>> ListarMascotas() {
        List<Mascota> mascotas = veterinariaServices.ListarMascotas();
        return ResponseEntity.ok(mascotas);
    }

}
