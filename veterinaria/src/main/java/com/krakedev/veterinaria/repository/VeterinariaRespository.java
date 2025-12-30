package com.krakedev.veterinaria.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.krakedev.veterinaria.entity.Mascota;

@Repository
public interface VeterinariaRespository extends JpaRepository<Mascota, Long> {

    // ESTE NO HACE FALTA, JpaRepository YA LO TIENE
    // Optional<Mascota> findById(Long idMascota);

    Optional<Mascota> findByNombre(String nombre);
}
