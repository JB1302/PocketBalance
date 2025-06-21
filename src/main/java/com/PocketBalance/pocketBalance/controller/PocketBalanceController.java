package com.PocketBalance.pocketBalance.controller;

import org.springframework.ui.Model;
import com.PocketBalance.pocketBalance.domain.PocketBalance;
import com.PocketBalance.pocketBalance.service.PocketBalanceService;
import java.sql.Timestamp;
import java.time.LocalDateTime; // ✅ Falta este import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PocketBalanceController {

    @Autowired
    private PocketBalanceService pocketBalanceService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("PocketBalances", pocketBalanceService.getBalances());
        model.addAttribute("PocketBalance", new PocketBalance());
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(PocketBalance pocketBalance) {
        pocketBalance.setUltima_actualizacion(Timestamp.valueOf(LocalDateTime.now())); // ✅ correcto
        pocketBalanceService.save(pocketBalance);
        return "redirect:/";
    }

    @PostMapping("/actualizar")
    public String actualizar(PocketBalance pocketBalance) {
        pocketBalance.setUltima_actualizacion(Timestamp.valueOf(LocalDateTime.now())); // ✅ actualiza la fecha
        pocketBalanceService.save(pocketBalance);
        return "redirect:/";
    }

    @PostMapping("/eliminar")
    public String eliminar(PocketBalance pocketBalance) {
        pocketBalanceService.delete(pocketBalance);
        return "redirect:/";
    }
}
