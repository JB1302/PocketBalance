package com.PocketBalance.pocketBalance.controller;

import org.springframework.ui.Model;
import com.PocketBalance.pocketBalance.domain.PocketBalance;
import com.PocketBalance.pocketBalance.service.PocketBalanceService;
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
    public String guardar(PocketBalance pocketBalance){
        pocketBalanceService.save(pocketBalance);
        return "redirect:/";
    }
    
    @PostMapping("/actualizar")
    public String actualizar(PocketBalance pocketBalance){
        pocketBalanceService.save(pocketBalance);
        return "redirect:/";
    }
    
    @PostMapping("/eliminar") // ✅ CAMBIADO
    public String eliminar(PocketBalance pocketBalance){
        pocketBalanceService.delete(pocketBalance);
        return "redirect:/";
    }
}
