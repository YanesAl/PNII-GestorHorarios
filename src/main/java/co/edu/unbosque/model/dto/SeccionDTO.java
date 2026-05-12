package co.edu.unbosque.model.dto;
import co.edu.unbosque.model.enums.EstadoSeccion;



public class SeccionDTO {
    private int idSeccion;
    private EstadoSeccion estadoSeccion;
    private int idGrupo;
    private int idAula;
    private int  idFranjaHoraria;

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public EstadoSeccion getEstadoSeccion() {
        return estadoSeccion;
    }

    public void setEstadoSeccion(EstadoSeccion estadoSeccion) {
        this.estadoSeccion = estadoSeccion;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public int getIdFranjaHoraria() {
        return idFranjaHoraria;
    }

    public void setIdFranjaHoraria(int idFranjaHoraria) {
        this.idFranjaHoraria = idFranjaHoraria;
    }
}