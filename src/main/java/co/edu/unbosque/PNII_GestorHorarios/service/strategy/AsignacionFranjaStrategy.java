package co.edu.unbosque.PNII_GestorHorarios.service.strategy;

import co.edu.unbosque.PNII_GestorHorarios.model.entity.FranjaHoraria;
import co.edu.unbosque.PNII_GestorHorarios.model.entity.Seccion;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoFranja;
import co.edu.unbosque.PNII_GestorHorarios.repository.FranjaHorariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Strategy concreta: asigna la primera franja disponible (no bloqueada, rango válido).
 */
@Component
@RequiredArgsConstructor
public class AsignacionFranjaStrategy implements AsignacionStrategy {

    private final FranjaHorariaRepository franjaRepository;

    @Override
    public boolean asignar(Seccion seccion) {
        if (seccion.getFranja() != null) return true;

        List<FranjaHoraria> franjas = franjaRepository.findAll();
        for (FranjaHoraria f : franjas) {
            if (EstadoFranja.DISPONIBLE.equals(f.getEstadoFranja())
                    && f.estaEnRangoPermitido()) {
                seccion.asignarFranja(f);
                return true;
            }
        }
        return false;
    }
}
