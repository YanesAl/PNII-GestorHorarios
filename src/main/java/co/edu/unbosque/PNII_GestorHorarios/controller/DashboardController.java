package co.edu.unbosque.PNII_GestorHorarios.controller;

import co.edu.unbosque.PNII_GestorHorarios.service.facade.HorarioFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final HorarioFacade facade;

    @GetMapping({"/", "/dashboard"})
    public String dashboard(Model model) {
        model.addAttribute("dashboard", facade.obtenerDashboard());
        model.addAttribute("conflictos", facade.detectarConflictos());
        return "dashboard";
    }
}
