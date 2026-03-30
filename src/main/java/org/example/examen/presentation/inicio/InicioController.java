package org.example.examen.presentation.inicio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/presentation/inicio")
public class InicioController {

    @GetMapping("/show")
    public String show() {
        return "presentation/inicio/View";
    }
}