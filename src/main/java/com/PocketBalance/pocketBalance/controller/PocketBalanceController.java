package com.PocketBalance.pocketBalance.controller;

import com.PocketBalance.pocketBalance.domain.PocketBalance;
import com.PocketBalance.pocketBalance.service.PocketBalanceService;
import com.pocketbalance.pocketbalance.domain.Salario;
import com.pocketbalance.pocketbalance.service.SalarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
public class PocketBalanceController {

    @Autowired
    private PocketBalanceService pocketBalanceService;

    @Autowired
    private SalarioService salarioService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("PocketBalances", pocketBalanceService.getBalances());
        model.addAttribute("PocketBalance", new PocketBalance());

        Salario salario = salarioService.getSalarios().stream().findFirst().orElse(new Salario());
        model.addAttribute("salario", salario.getSalario_Actual());
        model.addAttribute("salarioObjeto", salario);

        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(PocketBalance pocketBalance) {
        pocketBalance.setUltima_actualizacion(Timestamp.valueOf(LocalDateTime.now()));
        pocketBalanceService.save(pocketBalance);
        return "redirect:/";
    }

    @PostMapping("/actualizar")
    public String actualizar(PocketBalance pocketBalance) {
        pocketBalance.setUltima_actualizacion(Timestamp.valueOf(LocalDateTime.now()));
        pocketBalanceService.save(pocketBalance);
        return "redirect:/";
    }

    @PostMapping("/eliminar")
    public String eliminar(PocketBalance pocketBalance) {
        pocketBalanceService.delete(pocketBalance);
        return "redirect:/";
    }
}
