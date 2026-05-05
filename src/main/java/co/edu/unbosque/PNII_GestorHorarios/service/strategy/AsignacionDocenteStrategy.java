package co.edu.unbosque.PNII_GestorHorarios.service.strategy;

import co.edu.unbosque.PNII_GestorHorarios.model.entity.Docente;
import co.edu.unbosque.PNII_GestorHorarios.model.entity.Seccion;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoDocente;
import co.edu.unbosque.PNII_GestorHorarios.repository.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Strategy concreta: asigna el primer docente activo con cupo de horas disponible.
 */
@Component
@RequiredArgsConstructor
public class AsignacionDocenteStrategy implements AsignacionStrategy {

    private final DocenteRepository docenteRepository;

    @Override
    public boolean asignar(Seccion seccion) {
        if (seccion.getDocente() != null) return true; // ya asignado

        List<Docente> activos = docenteRepository.findByEstadoDocente(EstadoDocente.ACTIVO);
        for (Docente d : activos) {
            if (d.tieneCupoHoras()
                    && (seccion.getFranja() == null || d.estaDisponible(seccion.getFranja()))) {
                seccion.asignarDocente(d);
                return true;
            }
        }
        return false;
    }
}
