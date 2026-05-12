package co.edu.unbosque.model.dto;
import co.edu.unbosque.model.enums.EstadoEstudiante;

public class EstudianteDTO extends PersonaDTO {

    private String correo;
    private int semestreCursa;
    private EstadoEstudiante estadoEstudiante;
    private int creditosAprobados;


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getSemestreCursa() {
        return semestreCursa;
    }

    public void setSemestreCursa(int semestreCursa) {
        this.semestreCursa = semestreCursa;
    }

    public EstadoEstudiante getEstadoEstudiante() {
        return estadoEstudiante;
    }

    public void setEstadoEstudiante(EstadoEstudiante estadoEstudiante) {
        this.estadoEstudiante = estadoEstudiante;
    }

    public int getCreditosAprobados() {
        return creditosAprobados;
    }

    public void setCreditosAprobados(int creditosAprobados) {
        this.creditosAprobados = creditosAprobados;
    }
}