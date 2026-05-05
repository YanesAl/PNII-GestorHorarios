package co.edu.unbosque.PNII_GestorHorarios.service.strategy;

import co.edu.unbosque.PNII_GestorHorarios.model.entity.Seccion;

/**
 * Strategy (GoF): define el contrato para cada algoritmo de asignación.
 * Cada implementación encapsula un criterio independiente (docente, aula, franja).
 */
public interface AsignacionStrategy {
    /**
     * @param seccion la sección que requiere asignación
     * @return true si la asignación fue exitosa
     */
    boolean asignar(Seccion seccion);
}

