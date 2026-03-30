package org.example.examen.data;

import org.example.examen.logic.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,String> {
}
