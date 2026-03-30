package org.example.examen.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootRedirectController {
    @GetMapping("/")
    public String redirect() {
        return "redirect:/presentation/inicio/show";
    }
}