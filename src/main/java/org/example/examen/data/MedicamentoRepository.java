package org.example.examen.data;

import org.example.examen.logic.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento,String> {
}
