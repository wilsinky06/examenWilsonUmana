package org.example.examen.logic;

import org.example.examen.data.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private UsuarioRepository usuarios;

    @Autowired
    private PacienteRepository pacientes;

    @Autowired
    private MedicamentoRepository medicamentos;

    @Autowired
    private PacientemedicamentoRepository pacienteMedicamentos;

    @Autowired
    private FarmaciaRepository farmacias;

    public Farmacia farmaciaByUsuarioId(String usuarioId) {
        return farmacias.findByUsuarioId(usuarioId).orElseThrow(()->new RuntimeException("Farmacia no pillada"));
    }

    public Paciente buscarPaciente(String pacienteId) {
        return pacientes.findById(pacienteId).orElse(null);
    }

    public List<Pacientemedicamento> medicamentosDePaciente(String pacienteId){
        return pacienteMedicamentos.findByPacienteId(pacienteId);
    }

    public Medicamento buscarMedicamento(String medicamentoId) {
        return medicamentos.findById(medicamentoId).orElse(null);
    }

    public List<Medicamento> todosLosMedicamentos() {
        return medicamentos.findAll();
    }

    public String registrarCompra(int pmId, int cantidad){
        Pacientemedicamento pm = pacienteMedicamentos.findById(pmId).orElseThrow();
        int plan = pm.getMedicamento().getPlan();
        int actuales = pm.getDosisafavor();

        if(actuales >= plan){

            return "No se puede registrar compra ya que el paciente tiene le cantidad de dosis suficiente para canje";
        }

        int nuevasCantidad = actuales + cantidad;

        pm.setDosisafavor(nuevasCantidad);
        pacienteMedicamentos.save(pm);

        return null;
    }

    public String entregarRegalia(int pmId){
        Pacientemedicamento pm = pacienteMedicamentos.findById(pmId).orElseThrow();
        int plan = pm.getMedicamento().getPlan();
        int actuales = pm.getDosisafavor();

        if(actuales < plan){
            return "No hay dosis suficientes a favor para entregar";
        }

        pm.setDosisafavor(actuales-plan);
        pacienteMedicamentos.save(pm);
        return null;
    }
}
