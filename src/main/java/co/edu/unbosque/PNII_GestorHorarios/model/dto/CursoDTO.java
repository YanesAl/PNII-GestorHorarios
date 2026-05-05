package co.edu.unbosque.PNII_GestorHorarios.model.dto;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.AulaRequerida;

public record CursoDTO(
    Integer idCurso,
    String nombreCurso,
    Integer intensidadHoraria,
    Integer semestre,
    Integer creditos,
    AulaRequerida aulaRequerida
) {}