package group.crisalis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroController {
    @Autowired
   // private UsuarioService service;

    @GetMapping("/login")
    public String SignUp(){
        return "login";
    }

  /*   @GetMapping("/")
    public String verHome(Model modelo){
        modelo.addAttribute("usuarios", service.listarUsuarios());
        return "index";
    }
    */
}
