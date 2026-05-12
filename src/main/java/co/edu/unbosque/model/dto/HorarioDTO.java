package co.edu.unbosque.model.dto;

import java.io.Serializable;

public class HorarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    // ===== IDENTIFICADOR =====
    private int idSeccion;

    // ===== INFORMACIÓN “HUMANA” (LO QUE VES EN PANTALLA) =====
    private String nombreCurso;
    private String nombreDocente;
    private String nombreAula;
    private String nombreBloque;

    // ===== HORARIO =====
    private String diaSemana;
    private String horaInicio;
    private String horaFin;
    private String categoria;

    // ===== ESTADO =====
    private String estadoSeccion;

    // ===== GETTERS Y SETTERS =====

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getNombreAula() {
        return nombreAula;
    }

    public void setNombreAula(String nombreAula) {
        this.nombreAula = nombreAula;
    }

    public String getNombreBloque() {
        return nombreBloque;
    }

    public void setNombreBloque(String nombreBloque) {
        this.nombreBloque = nombreBloque;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstadoSeccion() {
        return estadoSeccion;
    }

    public void setEstadoSeccion(String estadoSeccion) {
        this.estadoSeccion = estadoSeccion;
    }
}