package com.krakedev.veterinaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.veterinaria.entity.Mascota;

@Repository
public interface VeterinariaRespository extends JpaRepository<Mascota, Long> {

    Optional<Mascota> findById(Long idMascota);

    Optional<Mascota> findByNombreMascota(String nombreMascota);

}
