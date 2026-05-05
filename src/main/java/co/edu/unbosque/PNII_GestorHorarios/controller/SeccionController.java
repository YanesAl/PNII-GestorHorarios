package co.edu.unbosque.PNII_GestorHorarios.controller;

import co.edu.unbosque.PNII_GestorHorarios.model.entity.Seccion;
import co.edu.unbosque.PNII_GestorHorarios.service.facade.HorarioFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/secciones")
@RequiredArgsConstructor
public class SeccionController {

    private final HorarioFacade facade;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("secciones", facade.listarSecciones());
        model.addAttribute("seccion", new Seccion());
        model.addAttribute("docentes", facade.listarDocentes());
        model.addAttribute("aulas", facade.listarAulas());
        model.addAttribute("franjas", facade.listarFranjas());
        model.addAttribute("cursos", facade.listarCursos());
        return "secciones";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Seccion seccion) {
        facade.guardarSeccion(seccion);
        return "redirect:/secciones";
    }

    @PostMapping("/asignar/{id}")
    public String asignarAutomatico(@PathVariable Integer id) {
        facade.ejecutarAsignacionAutomatica(id);
        return "redirect:/secciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        facade.eliminarSeccion(id);
        return "redirect:/secciones";
    }
}
