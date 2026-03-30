package org.example.examen.data;

import org.example.examen.logic.Pacientemedicamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacientemedicamentoRepository extends JpaRepository<Pacientemedicamento, Integer> {

    List<Pacientemedicamento> findByPacienteId(String pacienteId);

}
