package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.enums.TipoAula;
import java.util.List;

public class CursoDTO {

    private int idCurso;
    private String nombreCurso;
    private int intensidadHoraria;
    private int semestre;
    private int creditos;
    private TipoAula aulaRequerida;
    private List<Integer> idsPrerrequisitos;
    private List<Integer> idsGrupos;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getIntensidadHoraria() {
        return intensidadHoraria;
    }

    public void setIntensidadHoraria(int intensidadHoraria) {
        this.intensidadHoraria = intensidadHoraria;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public TipoAula getAulaRequerida() {
        return aulaRequerida;
    }

    public void setAulaRequerida(TipoAula aulaRequerida) {
        this.aulaRequerida = aulaRequerida;
    }

    public List<Integer> getIdsPrerrequisitos() {
        return idsPrerrequisitos;
    }

    public void setIdsPrerrequisitos(List<Integer> idsPrerrequisitos) {
        this.idsPrerrequisitos = idsPrerrequisitos;
    }

    public List<Integer> getIdsGrupos() {
        return idsGrupos;
    }

    public void setIdsGrupos(List<Integer> idsGrupos) {
        this.idsGrupos = idsGrupos;
    }
}