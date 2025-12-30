package com.krakedev.veterinaria.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.krakedev.veterinaria.entity.Mascota;
import com.krakedev.veterinaria.repository.VeterinariaRespository;
import com.krakedev.veterinaria.services.VeterinariaServices;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
@Service
public class VeterinariaServiceImpl implements VeterinariaServices {

    private final VeterinariaRespository veterinariaRespository;

    @Override
    public Mascota RegistrarMascota(Mascota newMascota) {
        return veterinariaRespository.save(newMascota);
    }

    @Override
    public List<Mascota> ListarMascotas() {
        return veterinariaRespository.findAll();
    }

    @Override
    public Optional<Mascota> BuscarPorNombreMascota(String nombreMascota) {
        return veterinariaRespository.findByNombre(nombreMascota);
    }

    @Override
    public Optional<Mascota> BuscarPorId(Long idMascota) {
        return veterinariaRespository.findById(idMascota);
    }

    @Override
    @SneakyThrows
    public Mascota actualizarMascota(Long idMascota, Mascota mascotaActualizada) {

        Mascota mascotaExistente = veterinariaRespository.findById(idMascota)
                .orElseThrow(() -> new Exception("Masota no encontrada: " + idMascota + "No encontrada"));

        mascotaExistente.setNombre(mascotaActualizada.getNombre());
        mascotaExistente.setEdad(mascotaActualizada.getEdad());
        mascotaExistente.setEspecie(mascotaActualizada.getEspecie());
        mascotaExistente.setNombreDueno(mascotaActualizada.getNombreDueno());
        mascotaExistente.setFechaRegistro(mascotaActualizada.getFechaRegistro());
        return veterinariaRespository.save(mascotaExistente);
    }

    @SneakyThrows
    @Override
    public void eliminarMascota(Long idMascota) {

        veterinariaRespository.findById(idMascota)
                .orElseThrow(() -> new Exception("Masota no encontrada: " + idMascota + "No encontrada"));

        veterinariaRespository.deleteById(idMascota);

    }

}
