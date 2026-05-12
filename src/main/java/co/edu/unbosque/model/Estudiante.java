package co.edu.unbosque.model;
import co.edu.unbosque.model.enums.EstadoEstudiante;
import jakarta.persistence.*;

@Entity
@Table(name = "estudiante")
@PrimaryKeyJoinColumn(name = "id_persona")
public class Estudiante extends Persona {

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "semestre_cursa", nullable = false)
    private int semestreCursa;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_estudiante", nullable = false)
    private EstadoEstudiante estadoEstudiante;

    @Column(name = "creditos_aprobados", nullable = false)
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