package co.edu.unbosque.PNII_GestorHorarios.controller;
import co.edu.unbosque.PNII_GestorHorarios.model.entity.Docente;
import co.edu.unbosque.PNII_GestorHorarios.service.facade.HorarioFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/docentes")
@RequiredArgsConstructor
public class DocenteController {

    private final HorarioFacade facade;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("docentes", facade.listarDocentes());
        model.addAttribute("docente", new Docente());
        return "docentes";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Docente docente) {
        facade.guardarDocente(docente);
        return "redirect:/docentes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        facade.buscarDocente(id).ifPresent(d -> model.addAttribute("docente", d));
        model.addAttribute("docentes", facade.listarDocentes());
        return "docentes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        facade.eliminarDocente(id);
        return "redirect:/docentes";
    }
}
