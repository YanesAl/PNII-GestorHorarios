package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.enums.EstadoGrupo;
import java.util.ArrayList;
import java.util.List;

public class GrupoDTO{

    private int idGrupo;
    private EstadoGrupo estadoGrupo;
    private int idCurso;
    private int idDocente;
    private List<Integer> idsEstudiantes;
    private List<Integer> idsSecciones;
    private int cupoMaximo;
    private int cupoMinimo;

    public GrupoDTO() {
        this.idsEstudiantes = new ArrayList<>();
        this.idsSecciones = new ArrayList<>();
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public EstadoGrupo getEstadoGrupo() {
        return estadoGrupo;
    }

    public void setEstadoGrupo(EstadoGrupo estadoGrupo) {
        this.estadoGrupo = estadoGrupo;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public List<Integer> getIdsEstudiantes() {
        return idsEstudiantes;
    }

    public void setIdsEstudiantes(List<Integer> idsEstudiantes) {
        this.idsEstudiantes = idsEstudiantes;
    }

    public List<Integer> getIdsSecciones() {
        return idsSecciones;
    }

    public void setIdsSecciones(List<Integer> idsSecciones) {
        this.idsSecciones = idsSecciones;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    public void setCupoMinimo(int cupoMinimo) {
        this.cupoMinimo = cupoMinimo;
    }
}