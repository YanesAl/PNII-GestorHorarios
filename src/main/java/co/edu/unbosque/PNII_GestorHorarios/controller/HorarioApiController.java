package co.edu.unbosque.PNII_GestorHorarios.controller;
import co.edu.unbosque.PNII_GestorHorarios.model.dto.DashboardDTO;
import co.edu.unbosque.PNII_GestorHorarios.model.entity.*;
import co.edu.unbosque.PNII_GestorHorarios.service.facade.HorarioFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API — complementa la UI Thymeleaf para operaciones AJAX o integración futura.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HorarioApiController {

    private final HorarioFacade facade;

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardDTO> dashboard() {
        return ResponseEntity.ok(facade.obtenerDashboard());
    }

    @GetMapping("/docentes")
    public ResponseEntity<List<Docente>> docentes() {
        return ResponseEntity.ok(facade.listarDocentes());
    }

    @GetMapping("/aulas")
    public ResponseEntity<List<Aula>> aulas() {
        return ResponseEntity.ok(facade.listarAulas());
    }

    @GetMapping("/secciones")
    public ResponseEntity<List<Seccion>> secciones() {
        return ResponseEntity.ok(facade.listarSecciones());
    }

    @PostMapping("/secciones/{id}/asignar")
    public ResponseEntity<Seccion> asignar(@PathVariable Integer id) {
        return ResponseEntity.ok(facade.ejecutarAsignacionAutomatica(id));
    }

    @GetMapping("/conflictos")
    public ResponseEntity<List<Seccion>> conflictos() {
        return ResponseEntity.ok(facade.detectarConflictos());
    }
}
