package co.edu.unbosque.PNII_GestorHorarios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plan_estudios")
public class PlanEstudios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlanEstudios;

    private String nombrePlanEstudios;
    private String codigoPlanEstudios;
    private Integer numeroCreditosTotal;

    @ManyToOne
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @OneToMany(mappedBy = "planEstudios", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursos = new ArrayList<>();

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
        curso.setPlanEstudios(this);
    }

    public void removerCurso(Curso curso) {
        cursos.remove(curso);
        curso.setPlanEstudios(null);
    }

    public List<Curso> obtenerCursos() {
        return cursos;
    }

    public Boolean tieneCurso(Curso curso) {
        return cursos.contains(curso);
    }
}