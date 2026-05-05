package co.edu.unbosque.PNII_GestorHorarios.model.dto;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoGrupo;
import java.util.List;

public record GrupoDTO(
    Integer idGrupo,
    EstadoGrupo estadoGrupo,
    List<EstudianteDTO> estudiantes
) {}