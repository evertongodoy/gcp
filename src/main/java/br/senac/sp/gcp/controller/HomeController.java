package br.senac.sp.gcp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Olá, Spring Boot + Thymeleaf!");
        model.addAttribute("mensagem", "Oi, essa mensagem veio do controller.");
        return "index"; // procura templates/index.html
    }

}
