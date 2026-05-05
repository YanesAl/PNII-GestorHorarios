package co.edu.unbosque.PNII_GestorHorarios.model.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DashboardDTO {
    private long totalDocentes;
    private long docentesActivos;
    private long totalAulas;
    private long aulasDisponibles;
    private long totalSecciones;
    private long seccionesAsignadas;
    private long seccionesConConflicto;
    private long totalCursos;
    private long totalEstudiantes;
}
