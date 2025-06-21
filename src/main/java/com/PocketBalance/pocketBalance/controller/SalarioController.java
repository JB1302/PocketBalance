package com.pocketbalance.pocketbalance.controller;

import com.pocketbalance.pocketbalance.domain.Salario;
import com.pocketbalance.pocketbalance.service.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
public class SalarioController {

    @Autowired
    private SalarioService salarioService;

    @PostMapping("/actualizarSalario")
    public String actualizarSalario(@ModelAttribute("salarioObjeto") Salario salario) {
        salario.setUltima_actualizacion(Timestamp.valueOf(LocalDateTime.now()));
        salarioService.save(salario);
        return "redirect:/";
    }

}
