package com.rodalm.interfaceWeb4Linux.controlador;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.rodalm.interfaceWeb4Linux.modelo.Acesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorPaginaLogin {

    @Autowired
    private ConexaoSSH conexaoSSH;

    @GetMapping("/login")
    public String showLoginForm(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model modelo) {

        if (error != null) {
            modelo.addAttribute("errorMessage", "Crencendias inválidas!");
        }
        if (logout != null) {
            modelo.addAttribute("logoutMessage", "Logout realizado com sucesso!");
        }
        return "login";
    }

    @PostMapping("/login")
    public String conectar(@ModelAttribute Acesso acesso){
        try{
            Session session = conexaoSSH.conectar(acesso);
            return "home";
        } catch (JSchException e){
            System.out.println("Erro: " + e.getMessage());
        return "login";
        }
    }
}
