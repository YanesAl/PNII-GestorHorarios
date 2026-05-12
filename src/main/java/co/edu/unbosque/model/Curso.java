package co.edu.unbosque.model;

import co.edu.unbosque.model.enums.TipoAula;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private int idCurso;

    @Column(name = "nombre_curso", nullable = false)
    private String nombreCurso;

    @Column(name = "intensidad_horaria", nullable = false)
    private int intensidadHoraria;

    @Column(name = "semestre", nullable = false)
    private int semestre;

    @Column(name = "creditos", nullable = false)
    private int creditos;

    @Enumerated(EnumType.STRING)
    @Column(name = "aula_requerida", nullable = false)
    private TipoAula aulaRequerida;

    @ManyToMany
    @JoinTable(
            name = "curso_prerrequisito",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_prerrequisito")
    )
    private List<Curso> prerrequisitos;

    @OneToMany(mappedBy = "curso")
    private List<Grupo> grupos;

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
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

    public List<Curso> getPrerrequisitos() {
        return prerrequisitos;
    }

    public void setPrerrequisitos(List<Curso> prerrequisitos) {
        this.prerrequisitos = prerrequisitos;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
}