package co.edu.unbosque.PNII_GestorHorarios.model.dto;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoEstudiante;

public record EstudianteDTO(
    Integer idEstudiante,
    String nombreEstudiante,
    String apellidoEstudiante,
    String correo,
    Integer semestreCursa,
    EstadoEstudiante estadoEstudiante,
    Integer creditosAprobados
) 
