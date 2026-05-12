package co.edu.unbosque.model;

import co.edu.unbosque.model.enums.EstadoGrupo;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupo")
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private int idGrupo;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_grupo")
    private EstadoGrupo estadoGrupo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "grupo_estudiante",
            joinColumns = @JoinColumn(name = "id_grupo"),
            inverseJoinColumns = @JoinColumn(name = "id_estudiante")
    )
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<Seccion> secciones;

    @Column(name = "cupo_maximo")
    private int cupoMaximo;

    @Column(name = "cupo_minimo")
    private int cupoMinimo;

    public Grupo() {
        this.estudiantes = new ArrayList<>();
        this.secciones = new ArrayList<>();
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
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