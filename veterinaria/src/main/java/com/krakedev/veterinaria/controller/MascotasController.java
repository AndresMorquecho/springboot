package com.krakedev.veterinaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinaria.entity.EstadoMascota;
import com.krakedev.veterinaria.entity.Mascota;
import com.krakedev.veterinaria.services.VeterinariaServices;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre) {
        Optional<Mascota> mascota = veterinariaServices.BuscarPorNombreMascota(nombre);

        return mascota.isPresent() ? ResponseEntity.ok(mascota.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("mascota no encontrada");

    }

    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Mascota> mascota = veterinariaServices.BuscarPorId(id);

        return mascota.isPresent() ? ResponseEntity.ok(mascota.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("mascota no encontrada");

    }

    @PutMapping("/actualizar/id/{id}")
    public ResponseEntity<?> actualizarMascota(@PathVariable long id, @RequestBody Mascota mascota) {

        try {
            Mascota mascotaActualizada = new Mascota();
            mascotaActualizada.setEdad(mascota.getEdad());
            mascotaActualizada.setNombre(mascota.getNombre());
            mascotaActualizada.setEspecie(mascota.getEspecie());
            mascotaActualizada.setNombreDueno(mascota.getNombreDueno());
            mascotaActualizada.setFechaRegistro(mascota.getFechaRegistro());
            mascotaActualizada.setEstado(mascota.getEstado());

            Mascota mascotaBDD = veterinariaServices.actualizarMascota(id, mascotaActualizada);
            return ResponseEntity.ok(mascotaBDD);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/id/{id}")
    public ResponseEntity<?> eliminarMascota(@PathVariable long id) {
        try {
            veterinariaServices.eliminarMascota(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/estado/id/{id}")
    public ResponseEntity<?> cambiarEstadoMascota(@PathVariable long id, @RequestBody EstadoMascota estado) {

        try {

            Mascota mascotaActualizada = veterinariaServices.cambiarEstadoMascota(id, estado);
            return ResponseEntity.ok(mascotaActualizada);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }

    @GetMapping("/estado/{estadoMascota}")
    public ResponseEntity<List<Mascota>> ListarMascotasPorEstado(@PathVariable EstadoMascota estadoMascota) {

        List<Mascota> mascotas = veterinariaServices.obtenerPorEstado(estadoMascota);
        return ResponseEntity.ok(mascotas);
    }

}
