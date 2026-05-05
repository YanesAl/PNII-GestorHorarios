package co.edu.unbosque.PNII_GestorHorarios.service.strategy;

import co.edu.unbosque.PNII_GestorHorarios.model.entity.Aula;
import co.edu.unbosque.PNII_GestorHorarios.model.entity.Seccion;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoAula;
import co.edu.unbosque.PNII_GestorHorarios.repository.AulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Strategy concreta: asigna la primera aula disponible con capacidad suficiente.
 */
@Component
@RequiredArgsConstructor
public class AsignacionAulaStrategy implements AsignacionStrategy {

    private final AulaRepository aulaRepository;

    @Override
    public boolean asignar(Seccion seccion) {
        if (seccion.getAula() != null) return true;

        List<Aula> disponibles = aulaRepository.findByEstadoAula(EstadoAula.DISPONIBLE);
        for (Aula a : disponibles) {
            if (a.tieneCapacidad(seccion.getCupoMaximo())
                    && (seccion.getCurso() == null
                        || a.cumpleTipoRequerido(seccion.getCurso().getAulaRequerida()))) {
                seccion.asignarAula(a);
                return true;
            }
        }
        return false;
    }
}
