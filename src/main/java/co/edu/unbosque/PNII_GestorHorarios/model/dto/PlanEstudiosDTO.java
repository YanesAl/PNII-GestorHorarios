package co.edu.unbosque.PNII_GestorHorarios.model.dto;

import java.util.List;

public record PlanEstudiosDTO(
    Integer idPlanEstudios,
    String nombrePlanEstudios,
    String codigoPlanEstudios,
    Integer numeroCreditosTotal,
    List<CursoDTO> cursos
) {}