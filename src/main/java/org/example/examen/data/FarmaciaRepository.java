package org.example.examen.data;

import org.example.examen.logic.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FarmaciaRepository extends JpaRepository<Farmacia,String> {

    Optional<Farmacia> findByUsuarioId(String usuarioId);
}
