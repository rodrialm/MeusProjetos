package com.rodalm.interfaceWeb4Linux.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorPaginaHome {

    @GetMapping("/home")
    public String home(
            @RequestParam(value = "loginSuccess", required = false) boolean success,
            Model modelo) {
        String usuario = "rodrigo";

        if (success) {
            modelo.addAttribute("loginMessage", "Servidor Logado!");
        }
        return "home";
    }
}
