package co.edu.unbosque.model;

import co.edu.unbosque.model.enums.EstadoSeccion;
import jakarta.persistence.*;

@Entity
@Table(name = "seccion")
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seccion")
    private int idSeccion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_seccion")
    private EstadoSeccion estadoSeccion;

    @ManyToOne
    @JoinColumn(name = "id_grupo", nullable = false)
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "id_aula", nullable = false)
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "id_franja", nullable = false)
    private FranjaHoraria franjaHoraria;

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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public FranjaHoraria getFranjaHoraria() {
        return franjaHoraria;
    }

    public void setFranjaHoraria(FranjaHoraria franjaHoraria) {
        this.franjaHoraria = franjaHoraria;
    }
}