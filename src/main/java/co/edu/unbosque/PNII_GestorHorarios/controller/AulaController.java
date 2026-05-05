package co.edu.unbosque.PNII_GestorHorarios.controller;
import co.edu.unbosque.PNII_GestorHorarios.model.entity.Aula;
import co.edu.unbosque.PNII_GestorHorarios.service.facade.HorarioFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aulas")
@RequiredArgsConstructor
public class AulaController {

    private final HorarioFacade facade;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("aulas", facade.listarAulas());
        model.addAttribute("aula", new Aula());
        return "aulas";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Aula aula) {
        facade.guardarAula(aula);
        return "redirect:/aulas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        facade.buscarAula(id).ifPresent(a -> model.addAttribute("aula", a));
        model.addAttribute("aulas", facade.listarAulas());
        return "aulas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        facade.eliminarAula(id);
        return "redirect:/aulas";
    }
}
