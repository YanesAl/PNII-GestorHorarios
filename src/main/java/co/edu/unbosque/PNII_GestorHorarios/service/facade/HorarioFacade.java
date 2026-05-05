package co.edu.unbosque.PNII_GestorHorarios.service;

import co.edu.unbosque.PNII_GestorHorarios.model.dto.*;
import co.edu.unbosque.PNII_GestorHorarios.model.entity.*;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.*;
import co.edu.unbosque.PNII_GestorHorarios.repository.*;
import co.edu.unbosque.PNII_GestorHorarios.service.strategy.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Facade (GoF): centraliza las peticiones de la capa UI hacia la lógica de negocio.
 * En fase Wizard of Oz, devuelve datos simulados o persistidos según el estado del
 * backend real. Una vez completada la implementación, esta clase delega al motor
 * de asignación compuesto por las tres Strategy concretas.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class HorarioFacade {

    // Repositories
    private final DocenteRepository      docenteRepo;
    private final AulaRepository         aulaRepo;
    private final SeccionRepository      seccionRepo;
    private final FranjaHorariaRepository franjaRepo;
    private final CursoRepository        cursoRepo;
    private final EstudianteRepository   estudianteRepo;
    private final GrupoRepository        grupoRepo;
    private final FacultadRepository     facultadRepo;
    private final CarreraRepository      carreraRepo;

    // Strategies
    private final AsignacionDocenteStrategy docenteStrategy;
    private final AsignacionAulaStrategy    aulaStrategy;
    private final AsignacionFranjaStrategy  franjaStrategy;

    // ── Dashboard ──────────────────────────────────────────────────────────────

    public DashboardDTO obtenerDashboard() {
        return DashboardDTO.builder()
            .totalDocentes(docenteRepo.count())
            .docentesActivos(docenteRepo.findByEstadoDocente(EstadoDocente.ACTIVO).size())
            .totalAulas(aulaRepo.count())
            .aulasDisponibles(aulaRepo.findByEstadoAula(EstadoAula.DISPONIBLE).size())
            .totalSecciones(seccionRepo.count())
            .seccionesAsignadas(seccionRepo.findByEstadoSeccion(EstadoSeccion.ASIGNADA).size())
            .seccionesConConflicto(seccionRepo.findByEstadoSeccion(EstadoSeccion.CONFLICTO).size())
            .totalCursos(cursoRepo.count())
            .totalEstudiantes(estudianteRepo.count())
            .build();
    }

    // ── Docentes ───────────────────────────────────────────────────────────────

    public List<Docente> listarDocentes() {
        return docenteRepo.findAll();
    }

    public Optional<Docente> buscarDocente(Integer id) {
        return docenteRepo.findById(id);
    }

    public Docente guardarDocente(Docente docente) {
        if (docente.getHorasAsignadas() == null) docente.setHorasAsignadas(0);
        return docenteRepo.save(docente);
    }

    public void eliminarDocente(Integer id) {
        docenteRepo.deleteById(id);
    }

    // ── Aulas ──────────────────────────────────────────────────────────────────

    public List<Aula> listarAulas() {
        return aulaRepo.findAll();
    }

    public Optional<Aula> buscarAula(Integer id) {
        return aulaRepo.findById(id);
    }

    public Aula guardarAula(Aula aula) {
        return aulaRepo.save(aula);
    }

    public void eliminarAula(Integer id) {
        aulaRepo.deleteById(id);
    }

    // ── Secciones ──────────────────────────────────────────────────────────────

    public List<Seccion> listarSecciones() {
        return seccionRepo.findAll();
    }

    public Optional<Seccion> buscarSeccion(Integer id) {
        return seccionRepo.findById(id);
    }

    public Seccion guardarSeccion(Seccion seccion) {
        return seccionRepo.save(seccion);
    }

    public void eliminarSeccion(Integer id) {
        seccionRepo.deleteById(id);
    }

    // ── Franjas ────────────────────────────────────────────────────────────────

    public List<FranjaHoraria> listarFranjas() {
        return franjaRepo.findAll();
    }

    public FranjaHoraria guardarFranja(FranjaHoraria franja) {
        return franjaRepo.save(franja);
    }

    // ── Cursos ─────────────────────────────────────────────────────────────────

    public List<Curso> listarCursos() {
        return cursoRepo.findAll();
    }

    public Curso guardarCurso(Curso curso) {
        return cursoRepo.save(curso);
    }

    // ── Motor de asignación (Strategy) ────────────────────────────────────────

    /**
     * Ejecuta las tres strategies en cadena sobre una sección.
     * Orden: franja → aula → docente (dependencias de arriba hacia abajo).
     * @return la sección actualizada con estado ASIGNADA o CONFLICTO
     */
    public Seccion ejecutarAsignacionAutomatica(Integer idSeccion) {
        Seccion seccion = seccionRepo.findById(idSeccion)
            .orElseThrow(() -> new IllegalArgumentException("Sección no encontrada: " + idSeccion));

        boolean franjaOk  = franjaStrategy.asignar(seccion);
        boolean aulaOk    = aulaStrategy.asignar(seccion);
        boolean docenteOk = docenteStrategy.asignar(seccion);

        if (franjaOk && aulaOk && docenteOk) {
            seccion.setEstadoSeccion(EstadoSeccion.ASIGNADA);
        } else {
            seccion.setEstadoSeccion(EstadoSeccion.CONFLICTO);
        }

        return seccionRepo.save(seccion);
    }

    /**
     * Detecta conflictos de horario entre secciones: mismo aula + misma franja.
     */
    public List<Seccion> detectarConflictos() {
        return seccionRepo.findByEstadoSeccion(EstadoSeccion.CONFLICTO);
    }

    // ── Grupos y Estudiantes ───────────────────────────────────────────────────

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepo.findAll();
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepo.save(estudiante);
    }
}
