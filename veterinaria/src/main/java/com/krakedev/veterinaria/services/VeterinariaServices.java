package com.krakedev.veterinaria.services;

import java.util.List;
import java.util.Optional;

import com.krakedev.veterinaria.entity.Mascota;

public interface VeterinariaServices {

    Mascota RegistrarMascota(Mascota newMascota);

    List<Mascota> ListarMascotas();

    Optional<Mascota> BuscarPorNombreMascota(String nombreMascota);

    Optional<Mascota> BuscarPorId(Long idMascota);

    Mascota actualizarMascota(Long idMascota, Mascota mascotaActualizada);

    void eliminarMascota(Long idMascota);

}
