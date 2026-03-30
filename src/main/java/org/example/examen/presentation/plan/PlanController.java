package org.example.examen.presentation.plan;

import org.example.examen.logic.*;
import org.example.examen.security.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("/presentation/plan")
@SessionAttributes("cedulaBuscada")
public class PlanController {

    @Autowired
    private Service service;

    @ModelAttribute("cedulaBuscada")
    public String cedulaBuscada() {
        return "";
    }

    @GetMapping("/show")
    public String show(Model model,
                       @AuthenticationPrincipal UserDetailsImp userDetails,
                       @ModelAttribute("cedulaBuscada") String cedulaBuscada,
                       SessionStatus sessionStatus) {

        Farmacia farmacia = service.farmaciaByUsuarioId(userDetails.getUsuario().getId());
        model.addAttribute("farmacia", farmacia);
        model.addAttribute("cedulaBuscada", cedulaBuscada);

        if (cedulaBuscada != null && !cedulaBuscada.isEmpty()) {
            Paciente paciente = service.buscarPaciente(cedulaBuscada);
            model.addAttribute("paciente", paciente);
            if (paciente != null) {
                List<Pacientemedicamento> medicamentos = service.medicamentosDePaciente(cedulaBuscada);
                model.addAttribute("medicamentos", medicamentos);
            }
        }

        return "presentation/plan/View";
    }

    @PostMapping("/buscar")
    public String buscar(Model model,
                         @RequestParam("cedula") String cedula,
                         @AuthenticationPrincipal UserDetailsImp userDetails,
                         @ModelAttribute("cedulaBuscada") String cedulaBuscada) {

        model.addAttribute("cedulaBuscada", cedula);

        Farmacia farmacia = service.farmaciaByUsuarioId(userDetails.getUsuario().getId());
        model.addAttribute("farmacia", farmacia);

        Paciente paciente = service.buscarPaciente(cedula);
        model.addAttribute("paciente", paciente);

        if (paciente != null) {
            List<Pacientemedicamento> medicamentos = service.medicamentosDePaciente(cedula);
            model.addAttribute("medicamentos", medicamentos);
        }

        return "presentation/plan/View";
    }

    @PostMapping("/registrar")
    public String registrar(@RequestParam("pmId") int pmId,
                            @RequestParam("cantidad") int cantidad,
                            @ModelAttribute("cedulaBuscada") String cedulaBuscada,
                            @AuthenticationPrincipal UserDetailsImp userDetails,
                            Model model) {

        String error = service.registrarCompra(pmId, cantidad);

        Farmacia farmacia = service.farmaciaByUsuarioId(userDetails.getUsuario().getId());
        model.addAttribute("farmacia", farmacia);
        model.addAttribute("cedulaBuscada", cedulaBuscada);

        Paciente paciente = service.buscarPaciente(cedulaBuscada);
        model.addAttribute("paciente", paciente);

        if (paciente != null) {
            List<Pacientemedicamento> medicamentos = service.medicamentosDePaciente(cedulaBuscada);
            model.addAttribute("medicamentos", medicamentos);
        }

        if (error != null) {
            model.addAttribute("error", error);
        }

        return "presentation/plan/View";
    }

    @PostMapping("/entregar")
    public String entregar(@RequestParam("pmId") int pmId,
                           @ModelAttribute("cedulaBuscada") String cedulaBuscada,
                           @AuthenticationPrincipal UserDetailsImp userDetails,
                           Model model) {

        String error = service.entregarRegalia(pmId);

        Farmacia farmacia = service.farmaciaByUsuarioId(userDetails.getUsuario().getId());
        model.addAttribute("farmacia", farmacia);
        model.addAttribute("cedulaBuscada", cedulaBuscada);

        Paciente paciente = service.buscarPaciente(cedulaBuscada);
        model.addAttribute("paciente", paciente);

        if (paciente != null) {
            List<Pacientemedicamento> medicamentos = service.medicamentosDePaciente(cedulaBuscada);
            model.addAttribute("medicamentos", medicamentos);
        }

        if (error != null) {
            model.addAttribute("error", error);
        }

        return "presentation/plan/View";
    }
}